package com.example.calculator;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Addition service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: calculator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AdditionServiceGrpc {

  private AdditionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "calculator.AdditionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.calculator.OperationRequest,
      com.example.calculator.OperationResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Add",
      requestType = com.example.calculator.OperationRequest.class,
      responseType = com.example.calculator.OperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.calculator.OperationRequest,
      com.example.calculator.OperationResponse> getAddMethod() {
    io.grpc.MethodDescriptor<com.example.calculator.OperationRequest, com.example.calculator.OperationResponse> getAddMethod;
    if ((getAddMethod = AdditionServiceGrpc.getAddMethod) == null) {
      synchronized (AdditionServiceGrpc.class) {
        if ((getAddMethod = AdditionServiceGrpc.getAddMethod) == null) {
          AdditionServiceGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<com.example.calculator.OperationRequest, com.example.calculator.OperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.calculator.OperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.calculator.OperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdditionServiceMethodDescriptorSupplier("Add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.calculator.LogRequest,
      com.example.calculator.LogEntry> getGetLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLogs",
      requestType = com.example.calculator.LogRequest.class,
      responseType = com.example.calculator.LogEntry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.calculator.LogRequest,
      com.example.calculator.LogEntry> getGetLogsMethod() {
    io.grpc.MethodDescriptor<com.example.calculator.LogRequest, com.example.calculator.LogEntry> getGetLogsMethod;
    if ((getGetLogsMethod = AdditionServiceGrpc.getGetLogsMethod) == null) {
      synchronized (AdditionServiceGrpc.class) {
        if ((getGetLogsMethod = AdditionServiceGrpc.getGetLogsMethod) == null) {
          AdditionServiceGrpc.getGetLogsMethod = getGetLogsMethod =
              io.grpc.MethodDescriptor.<com.example.calculator.LogRequest, com.example.calculator.LogEntry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.calculator.LogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.calculator.LogEntry.getDefaultInstance()))
              .setSchemaDescriptor(new AdditionServiceMethodDescriptorSupplier("GetLogs"))
              .build();
        }
      }
    }
    return getGetLogsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdditionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdditionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdditionServiceStub>() {
        @java.lang.Override
        public AdditionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdditionServiceStub(channel, callOptions);
        }
      };
    return AdditionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdditionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdditionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdditionServiceBlockingStub>() {
        @java.lang.Override
        public AdditionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdditionServiceBlockingStub(channel, callOptions);
        }
      };
    return AdditionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdditionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdditionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdditionServiceFutureStub>() {
        @java.lang.Override
        public AdditionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdditionServiceFutureStub(channel, callOptions);
        }
      };
    return AdditionServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Addition service
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void add(com.example.calculator.OperationRequest request,
        io.grpc.stub.StreamObserver<com.example.calculator.OperationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    default void getLogs(com.example.calculator.LogRequest request,
        io.grpc.stub.StreamObserver<com.example.calculator.LogEntry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLogsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AdditionService.
   * <pre>
   * Addition service
   * </pre>
   */
  public static abstract class AdditionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AdditionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AdditionService.
   * <pre>
   * Addition service
   * </pre>
   */
  public static final class AdditionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AdditionServiceStub> {
    private AdditionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdditionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdditionServiceStub(channel, callOptions);
    }

    /**
     */
    public void add(com.example.calculator.OperationRequest request,
        io.grpc.stub.StreamObserver<com.example.calculator.OperationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLogs(com.example.calculator.LogRequest request,
        io.grpc.stub.StreamObserver<com.example.calculator.LogEntry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetLogsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AdditionService.
   * <pre>
   * Addition service
   * </pre>
   */
  public static final class AdditionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AdditionServiceBlockingStub> {
    private AdditionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdditionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdditionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.calculator.OperationResponse add(com.example.calculator.OperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.calculator.LogEntry> getLogs(
        com.example.calculator.LogRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetLogsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AdditionService.
   * <pre>
   * Addition service
   * </pre>
   */
  public static final class AdditionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AdditionServiceFutureStub> {
    private AdditionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdditionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdditionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.calculator.OperationResponse> add(
        com.example.calculator.OperationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_GET_LOGS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((com.example.calculator.OperationRequest) request,
              (io.grpc.stub.StreamObserver<com.example.calculator.OperationResponse>) responseObserver);
          break;
        case METHODID_GET_LOGS:
          serviceImpl.getLogs((com.example.calculator.LogRequest) request,
              (io.grpc.stub.StreamObserver<com.example.calculator.LogEntry>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.calculator.OperationRequest,
              com.example.calculator.OperationResponse>(
                service, METHODID_ADD)))
        .addMethod(
          getGetLogsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.calculator.LogRequest,
              com.example.calculator.LogEntry>(
                service, METHODID_GET_LOGS)))
        .build();
  }

  private static abstract class AdditionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdditionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.calculator.Calculator.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdditionService");
    }
  }

  private static final class AdditionServiceFileDescriptorSupplier
      extends AdditionServiceBaseDescriptorSupplier {
    AdditionServiceFileDescriptorSupplier() {}
  }

  private static final class AdditionServiceMethodDescriptorSupplier
      extends AdditionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AdditionServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AdditionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdditionServiceFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .addMethod(getGetLogsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
