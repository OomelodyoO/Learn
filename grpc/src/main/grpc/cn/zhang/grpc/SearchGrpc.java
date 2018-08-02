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
    comments = "Source: Search.proto")
public final class SearchGrpc {

  private SearchGrpc() {}

  public static final String SERVICE_NAME = "Search";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain,
      cn.zhang.proto.IpProto.IP> getSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "search",
      requestType = cn.zhang.proto.DomainProto.Domain.class,
      responseType = cn.zhang.proto.IpProto.IP.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain,
      cn.zhang.proto.IpProto.IP> getSearchMethod() {
    io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain, cn.zhang.proto.IpProto.IP> getSearchMethod;
    if ((getSearchMethod = SearchGrpc.getSearchMethod) == null) {
      synchronized (SearchGrpc.class) {
        if ((getSearchMethod = SearchGrpc.getSearchMethod) == null) {
          SearchGrpc.getSearchMethod = getSearchMethod = 
              io.grpc.MethodDescriptor.<cn.zhang.proto.DomainProto.Domain, cn.zhang.proto.IpProto.IP>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Search", "search"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.DomainProto.Domain.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.IpProto.IP.getDefaultInstance()))
                  .setSchemaDescriptor(new SearchMethodDescriptorSupplier("search"))
                  .build();
          }
        }
     }
     return getSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain,
      cn.zhang.proto.IpProto.IP> getSearchServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchServerStream",
      requestType = cn.zhang.proto.DomainProto.Domain.class,
      responseType = cn.zhang.proto.IpProto.IP.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain,
      cn.zhang.proto.IpProto.IP> getSearchServerStreamMethod() {
    io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain, cn.zhang.proto.IpProto.IP> getSearchServerStreamMethod;
    if ((getSearchServerStreamMethod = SearchGrpc.getSearchServerStreamMethod) == null) {
      synchronized (SearchGrpc.class) {
        if ((getSearchServerStreamMethod = SearchGrpc.getSearchServerStreamMethod) == null) {
          SearchGrpc.getSearchServerStreamMethod = getSearchServerStreamMethod = 
              io.grpc.MethodDescriptor.<cn.zhang.proto.DomainProto.Domain, cn.zhang.proto.IpProto.IP>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Search", "searchServerStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.DomainProto.Domain.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.IpProto.IP.getDefaultInstance()))
                  .setSchemaDescriptor(new SearchMethodDescriptorSupplier("searchServerStream"))
                  .build();
          }
        }
     }
     return getSearchServerStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain,
      cn.zhang.proto.IpProto.IP> getSearchClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchClientStream",
      requestType = cn.zhang.proto.DomainProto.Domain.class,
      responseType = cn.zhang.proto.IpProto.IP.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain,
      cn.zhang.proto.IpProto.IP> getSearchClientStreamMethod() {
    io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain, cn.zhang.proto.IpProto.IP> getSearchClientStreamMethod;
    if ((getSearchClientStreamMethod = SearchGrpc.getSearchClientStreamMethod) == null) {
      synchronized (SearchGrpc.class) {
        if ((getSearchClientStreamMethod = SearchGrpc.getSearchClientStreamMethod) == null) {
          SearchGrpc.getSearchClientStreamMethod = getSearchClientStreamMethod = 
              io.grpc.MethodDescriptor.<cn.zhang.proto.DomainProto.Domain, cn.zhang.proto.IpProto.IP>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Search", "searchClientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.DomainProto.Domain.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.IpProto.IP.getDefaultInstance()))
                  .setSchemaDescriptor(new SearchMethodDescriptorSupplier("searchClientStream"))
                  .build();
          }
        }
     }
     return getSearchClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain,
      cn.zhang.proto.IpProto.IP> getSearchServerClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchServerClientStream",
      requestType = cn.zhang.proto.DomainProto.Domain.class,
      responseType = cn.zhang.proto.IpProto.IP.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain,
      cn.zhang.proto.IpProto.IP> getSearchServerClientStreamMethod() {
    io.grpc.MethodDescriptor<cn.zhang.proto.DomainProto.Domain, cn.zhang.proto.IpProto.IP> getSearchServerClientStreamMethod;
    if ((getSearchServerClientStreamMethod = SearchGrpc.getSearchServerClientStreamMethod) == null) {
      synchronized (SearchGrpc.class) {
        if ((getSearchServerClientStreamMethod = SearchGrpc.getSearchServerClientStreamMethod) == null) {
          SearchGrpc.getSearchServerClientStreamMethod = getSearchServerClientStreamMethod = 
              io.grpc.MethodDescriptor.<cn.zhang.proto.DomainProto.Domain, cn.zhang.proto.IpProto.IP>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Search", "searchServerClientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.DomainProto.Domain.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zhang.proto.IpProto.IP.getDefaultInstance()))
                  .setSchemaDescriptor(new SearchMethodDescriptorSupplier("searchServerClientStream"))
                  .build();
          }
        }
     }
     return getSearchServerClientStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SearchStub newStub(io.grpc.Channel channel) {
    return new SearchStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SearchBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SearchBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SearchFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SearchFutureStub(channel);
  }

  /**
   */
  public static abstract class SearchImplBase implements io.grpc.BindableService {

    /**
     */
    public void search(cn.zhang.proto.DomainProto.Domain request,
        io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchMethod(), responseObserver);
    }

    /**
     */
    public void searchServerStream(cn.zhang.proto.DomainProto.Domain request,
        io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchServerStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.zhang.proto.DomainProto.Domain> searchClientStream(
        io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP> responseObserver) {
      return asyncUnimplementedStreamingCall(getSearchClientStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.zhang.proto.DomainProto.Domain> searchServerClientStream(
        io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP> responseObserver) {
      return asyncUnimplementedStreamingCall(getSearchServerClientStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.zhang.proto.DomainProto.Domain,
                cn.zhang.proto.IpProto.IP>(
                  this, METHODID_SEARCH)))
          .addMethod(
            getSearchServerStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                cn.zhang.proto.DomainProto.Domain,
                cn.zhang.proto.IpProto.IP>(
                  this, METHODID_SEARCH_SERVER_STREAM)))
          .addMethod(
            getSearchClientStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                cn.zhang.proto.DomainProto.Domain,
                cn.zhang.proto.IpProto.IP>(
                  this, METHODID_SEARCH_CLIENT_STREAM)))
          .addMethod(
            getSearchServerClientStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                cn.zhang.proto.DomainProto.Domain,
                cn.zhang.proto.IpProto.IP>(
                  this, METHODID_SEARCH_SERVER_CLIENT_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class SearchStub extends io.grpc.stub.AbstractStub<SearchStub> {
    private SearchStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchStub(channel, callOptions);
    }

    /**
     */
    public void search(cn.zhang.proto.DomainProto.Domain request,
        io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchServerStream(cn.zhang.proto.DomainProto.Domain request,
        io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSearchServerStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.zhang.proto.DomainProto.Domain> searchClientStream(
        io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSearchClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.zhang.proto.DomainProto.Domain> searchServerClientStream(
        io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSearchServerClientStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SearchBlockingStub extends io.grpc.stub.AbstractStub<SearchBlockingStub> {
    private SearchBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.zhang.proto.IpProto.IP search(cn.zhang.proto.DomainProto.Domain request) {
      return blockingUnaryCall(
          getChannel(), getSearchMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<cn.zhang.proto.IpProto.IP> searchServerStream(
        cn.zhang.proto.DomainProto.Domain request) {
      return blockingServerStreamingCall(
          getChannel(), getSearchServerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SearchFutureStub extends io.grpc.stub.AbstractStub<SearchFutureStub> {
    private SearchFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.zhang.proto.IpProto.IP> search(
        cn.zhang.proto.DomainProto.Domain request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH = 0;
  private static final int METHODID_SEARCH_SERVER_STREAM = 1;
  private static final int METHODID_SEARCH_CLIENT_STREAM = 2;
  private static final int METHODID_SEARCH_SERVER_CLIENT_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SearchImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SearchImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH:
          serviceImpl.search((cn.zhang.proto.DomainProto.Domain) request,
              (io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP>) responseObserver);
          break;
        case METHODID_SEARCH_SERVER_STREAM:
          serviceImpl.searchServerStream((cn.zhang.proto.DomainProto.Domain) request,
              (io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP>) responseObserver);
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
        case METHODID_SEARCH_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.searchClientStream(
              (io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP>) responseObserver);
        case METHODID_SEARCH_SERVER_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.searchServerClientStream(
              (io.grpc.stub.StreamObserver<cn.zhang.proto.IpProto.IP>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SearchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SearchBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.zhang.grpc.SearchService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Search");
    }
  }

  private static final class SearchFileDescriptorSupplier
      extends SearchBaseDescriptorSupplier {
    SearchFileDescriptorSupplier() {}
  }

  private static final class SearchMethodDescriptorSupplier
      extends SearchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SearchMethodDescriptorSupplier(String methodName) {
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
      synchronized (SearchGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SearchFileDescriptorSupplier())
              .addMethod(getSearchMethod())
              .addMethod(getSearchServerStreamMethod())
              .addMethod(getSearchClientStreamMethod())
              .addMethod(getSearchServerClientStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
