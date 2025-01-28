package com.dailycodebuffer.salarym_service.service;


import com.dailycodebuffer.SalaryRequest;
import com.dailycodebuffer.SalaryResponse;
import com.dailycodebuffer.SalaryServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class SalaryServiceImpl extends SalaryServiceGrpc.SalaryServiceImplBase {


    @Override
    public void getSalary(SalaryRequest request, StreamObserver<SalaryResponse> responseObserver) {
       var name = request.getName();
       var message =  "Hello" + name + "!";
       var sr = SalaryResponse.newBuilder().setMessage(message + " Salary credited").build();
       responseObserver.onNext(sr);
       responseObserver.onCompleted();
    }
}






