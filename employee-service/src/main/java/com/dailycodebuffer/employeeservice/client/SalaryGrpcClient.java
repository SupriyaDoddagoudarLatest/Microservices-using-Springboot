/*
package com.dailycodebuffer.employeeservice.client;



import com.dailycodebuffer.SalaryServiceGrpc;
import com.dailycodebuffer.SalaryRequest;
import com.dailycodebuffer.SalaryResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;


@GrpcService
public class SalaryGrpcClient {


    @GrpcClient("salarym-service")
    private SalaryServiceGrpc.SalaryServiceBlockingStub salaryServiceStub;


    public String getSalary(String employeeName) {
        SalaryRequest request = SalaryRequest.newBuilder()
                .setName(employeeName)
                .build();
        SalaryResponse response = salaryServiceStub.getSalary(request);
        return response.getMessage();
    }
}
*/
