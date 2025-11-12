
import grpc
import calculator_pb2
import calculator_pb2_grpc
import threading

ADD_ADDR = "127.0.0.1:50051"
MUL_ADDR = "127.0.0.1:50052"

def call_add(a,b):
    with grpc.insecure_channel(ADD_ADDR) as ch:
        stub = calculator_pb2_grpc.AdditionServiceStub(ch)
        resp = stub.Add(calculator_pb2.OperationRequest(a=a,b=b))
        return resp.result

def call_mul(a,b):
    with grpc.insecure_channel(MUL_ADDR) as ch:
        stub = calculator_pb2_grpc.MultiplicationServiceStub(ch)
        resp = stub.Multiply(calculator_pb2.OperationRequest(a=a,b=b))
        return resp.result

def stream_logs_from(service_addr, svc_name):
    with grpc.insecure_channel(service_addr) as ch:
        if svc_name == "add":
            stub = calculator_pb2_grpc.AdditionServiceStub(ch)
            stream = stub.GetLogs(calculator_pb2.LogRequest())
        else:
            stub = calculator_pb2_grpc.MultiplicationServiceStub(ch)
            stream = stub.GetLogs(calculator_pb2.LogRequest())
        print(f"--- logs from {svc_name} ---")
        for entry in stream:
            print(entry.entry)

def main():
    print("Distributed calculator Gateway")
    mode = input("Type 'calc' to calculate or 'logs' to stream logs: ").strip()
    if mode == "calc":
        a = int(input("a: "))
        b = int(input("b: "))
        # call both concurrently
        r_add = None
        r_mul = None
        t1 = threading.Thread(target=lambda: print("Addition:", call_add(a,b)))
        t2 = threading.Thread(target=lambda: print("Multiplication:", call_mul(a,b)))
        t1.start(); t2.start()
        t1.join(); t2.join()
    elif mode == "logs":
        # stream logs concurrently
        t1 = threading.Thread(target=lambda: stream_logs_from(ADD_ADDR, "add"))
        t2 = threading.Thread(target=lambda: stream_logs_from(MUL_ADDR, "mul"))
        t1.start(); t2.start()
        t1.join(); t2.join()
    else:
        print("Unknown mode")

if __name__ == "__main__":
    main()
