package main

import (
	"context"
	"fmt"
	"log"
	"net"

	pb "distributed-calculator/go-addition/calculatorpb" // replace with module path where generated pb lives
	"os"
	"sync"
	"time"

	"google.golang.org/grpc"
)

const (
	port    = ":50051"
	logFile = "add.log"
)

type server struct {
	pb.UnimplementedAdditionServiceServer
	mu sync.Mutex
}

func (s *server) Add(ctx context.Context, req *pb.OperationRequest) (*pb.OperationResponse, error) {
	a := req.GetA()
	b := req.GetB()
	res := a + b
	entry := fmt.Sprintf("%s add %d %d = %d\n", time.Now().Format(time.RFC3339), a, b, res)
	s.mu.Lock()
	f, err := os.OpenFile(logFile, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err == nil {
		_, _ = f.WriteString(entry)
		f.Close()
	} else {
		log.Println("write log error:", err)
	}
	s.mu.Unlock()
	return &pb.OperationResponse{Result: res}, nil
}

func (s *server) GetLogs(req *pb.LogRequest, stream pb.AdditionService_GetLogsServer) error {
	s.mu.Lock()
	data, err := os.ReadFile(logFile)
	s.mu.Unlock()
	if err != nil {
		// no logs yet
		return nil
	}
	lines := string(data)
	for _, line := range splitLines(lines) {
		if len(line) > 0 {
			if err := stream.Send(&pb.LogEntry{Entry: line}); err != nil {
				return err
			}
		}
	}
	return nil
}

func splitLines(s string) []string {
	var res []string
	cur := ""
	for _, ch := range s {
		if ch == '\n' {
			res = append(res, cur)
			cur = ""
		} else {
			cur += string(ch)
		}
	}
	if cur != "" {
		res = append(res, cur)
	}
	return res
}

func main() {
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	pb.RegisterAdditionServiceServer(s, &server{})
	log.Printf("Addition server listening on %s", port)
	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
