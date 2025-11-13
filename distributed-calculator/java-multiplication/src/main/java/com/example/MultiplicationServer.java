package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

import com.example.calculator.LogEntry;
import com.example.calculator.LogRequest;
import com.example.calculator.MultiplicationServiceGrpc;
import com.example.calculator.OperationRequest;
import com.example.calculator.OperationResponse;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class MultiplicationServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50052)
            .addService(new MultiplicationServiceImpl())
            .build()
            .start();

        System.out.println("Java Multiplication server started on port 50052");
        server.awaitTermination();
    }

    static class MultiplicationServiceImpl extends MultiplicationServiceGrpc.MultiplicationServiceImplBase {
        private final File logFile = new File("mul.log");

        @Override
        public void multiply(OperationRequest req, StreamObserver<OperationResponse> responseObserver) {
            int a = req.getA();
            int b = req.getB();
            int res = a * b;

            String entry = Instant.now().toString() + " multiply " + a + " " + b + " = " + res + "\n";
            synchronized (this) {
                try (FileWriter fw = new FileWriter(logFile, true)) {
                    fw.write(entry);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            OperationResponse r = OperationResponse.newBuilder()
                    .setResult(res)
                    .build();

            responseObserver.onNext(r);
            responseObserver.onCompleted();
        }

        @Override
        public void getLogs(LogRequest request, StreamObserver<LogEntry> responseObserver) {
            synchronized (this) {
                if (!logFile.exists()) {
                    responseObserver.onCompleted();
                    return;
                }
                try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        responseObserver.onNext(LogEntry.newBuilder().setEntry(line).build());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            responseObserver.onCompleted();
        }
    }
}