package cn.zhang.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.14.0)",
    comments = "Source: Calculator.proto")
public final class CalculatorGrpc {

  private CalculatorGrpc() {}

  public static final String SERVICE_NAME = "Calculator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.zhang.proto.ValueOuterClass.Value,
      cn.zhang.proto.ValueOuterClass.Value> getCalculatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "calculator",
      requestType = cn.zhang.proto.ValueOuterClass.Value.class,
      responseType = cn.zhang.proto.ValueOuterClass.Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.zhang.proto.ValueOuterClass.Value,
      cn.zhang.proto.ValueOuterClass.Value> getCalculatorMethod() {
    io.grpc.MethodDescriptor<cn.zhang.proto.ValueOuterClass.Value, cn.zhang.proto.ValueOuterClass.Value> getCalculatorMethod;
    if ((getCalculatorMethod = CalculatorGrpc.getCalculatorMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getCalculatorMethod = CalculatorGrpc.getCalculatorMethod) == null) {
          CalculatorGrpc.getCalculatorMethod = getCalculatorMethod = 
              io.grpc.MethodDescriptor.<cn.zhang.proto.ValueOuterClass.Value, cn.zhang.proto.ValueOuterClass.Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Calculator", "calculator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.ValueOuterClass.Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.ValueOuterClass.Value.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("calculator"))
                  .build();
          }
        }
     }
     return getCalculatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.zhang.proto.ValueOuterClass.Value,
      cn.zhang.proto.ValueOuterClass.Value> getCalculatorServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "calculatorServerStream",
      requestType = cn.zhang.proto.ValueOuterClass.Value.class,
      responseType = cn.zhang.proto.ValueOuterClass.Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cn.zhang.proto.ValueOuterClass.Value,
      cn.zhang.proto.ValueOuterClass.Value> getCalculatorServerStreamMethod() {
    io.grpc.MethodDescriptor<cn.zhang.proto.ValueOuterClass.Value, cn.zhang.proto.ValueOuterClass.Value> getCalculatorServerStreamMethod;
    if ((getCalculatorServerStreamMethod = CalculatorGrpc.getCalculatorServerStreamMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getCalculatorServerStreamMethod = CalculatorGrpc.getCalculatorServerStreamMethod) == null) {
          CalculatorGrpc.getCalculatorServerStreamMethod = getCalculatorServerStreamMethod = 
              io.grpc.MethodDescriptor.<cn.zhang.proto.ValueOuterClass.Value, cn.zhang.proto.ValueOuterClass.Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Calculator", "calculatorServerStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.ValueOuterClass.Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.ValueOuterClass.Value.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("calculatorServerStream"))
                  .build();
          }
        }
     }
     return getCalculatorServerStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculatorStub newStub(io.grpc.Channel channel) {
    return new CalculatorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculatorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalculatorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculatorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalculatorFutureStub(channel);
  }

  /**
   */
  public static abstract class CalculatorImplBase implements io.grpc.BindableService {

    /**
     */
    public void calculator(cn.zhang.proto.ValueOuterClass.Value request,
        io.grpc.stub.StreamObserver<cn.zhang.proto.ValueOuterClass.Value> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculatorMethod(), responseObserver);
    }

    /**
     */
    public void calculatorServerStream(cn.zhang.proto.ValueOuterClass.Value request,
        io.grpc.stub.StreamObserver<cn.zhang.proto.ValueOuterClass.Value> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculatorServerStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculatorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.zhang.proto.ValueOuterClass.Value,
                cn.zhang.proto.ValueOuterClass.Value>(
                  this, METHODID_CALCULATOR)))
          .addMethod(
            getCalculatorServerStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                cn.zhang.proto.ValueOuterClass.Value,
                cn.zhang.proto.ValueOuterClass.Value>(
                  this, METHODID_CALCULATOR_SERVER_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class CalculatorStub extends io.grpc.stub.AbstractStub<CalculatorStub> {
    private CalculatorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorStub(channel, callOptions);
    }

    /**
     */
    public void calculator(cn.zhang.proto.ValueOuterClass.Value request,
        io.grpc.stub.StreamObserver<cn.zhang.proto.ValueOuterClass.Value> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculatorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void calculatorServerStream(cn.zhang.proto.ValueOuterClass.Value request,
        io.grpc.stub.StreamObserver<cn.zhang.proto.ValueOuterClass.Value> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCalculatorServerStreamMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CalculatorBlockingStub extends io.grpc.stub.AbstractStub<CalculatorBlockingStub> {
    private CalculatorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.zhang.proto.ValueOuterClass.Value calculator(cn.zhang.proto.ValueOuterClass.Value request) {
      return blockingUnaryCall(
          getChannel(), getCalculatorMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<cn.zhang.proto.ValueOuterClass.Value> calculatorServerStream(
        cn.zhang.proto.ValueOuterClass.Value request) {
      return blockingServerStreamingCall(
          getChannel(), getCalculatorServerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalculatorFutureStub extends io.grpc.stub.AbstractStub<CalculatorFutureStub> {
    private CalculatorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.zhang.proto.ValueOuterClass.Value> calculator(
        cn.zhang.proto.ValueOuterClass.Value request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculatorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATOR = 0;
  private static final int METHODID_CALCULATOR_SERVER_STREAM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculatorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculatorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATOR:
          serviceImpl.calculator((cn.zhang.proto.ValueOuterClass.Value) request,
              (io.grpc.stub.StreamObserver<cn.zhang.proto.ValueOuterClass.Value>) responseObserver);
          break;
        case METHODID_CALCULATOR_SERVER_STREAM:
          serviceImpl.calculatorServerStream((cn.zhang.proto.ValueOuterClass.Value) request,
              (io.grpc.stub.StreamObserver<cn.zhang.proto.ValueOuterClass.Value>) responseObserver);
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

  private static abstract class CalculatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.zhang.grpc.CalculatorOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Calculator");
    }
  }

  private static final class CalculatorFileDescriptorSupplier
      extends CalculatorBaseDescriptorSupplier {
    CalculatorFileDescriptorSupplier() {}
  }

  private static final class CalculatorMethodDescriptorSupplier
      extends CalculatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculatorMethodDescriptorSupplier(String methodName) {
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
      synchronized (CalculatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculatorFileDescriptorSupplier())
              .addMethod(getCalculatorMethod())
              .addMethod(getCalculatorServerStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
