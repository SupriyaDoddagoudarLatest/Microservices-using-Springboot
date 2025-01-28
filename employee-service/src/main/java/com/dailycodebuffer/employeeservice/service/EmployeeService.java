package com.dailycodebuffer.employeeservice.service;

import com.dailycodebuffer.SalaryRequest;
import com.dailycodebuffer.SalaryResponse;
import com.dailycodebuffer.SalaryServiceGrpc;
import io.grpc.BindableService;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@GrpcService
public class EmployeeService extends SalaryServiceGrpc.SalaryServiceImplBase implements BindableService {

    private final SalaryServiceGrpc.SalaryServiceBlockingStub salaryServiceStub;

    public EmployeeService(SalaryServiceGrpc.SalaryServiceBlockingStub salaryServiceStub) {
        this.salaryServiceStub = salaryServiceStub;
    }

    public String getSalary(String employeeName) {
        SalaryRequest request = SalaryRequest.newBuilder()
                .setName(employeeName)  // Use the builder pattern to set the employee name
                .build();

        SalaryResponse response = salaryServiceStub.getSalary(request);

        // Use the builder to construct the response if needed
        SalaryResponse responseMessage = SalaryResponse.newBuilder()
                .setMessage(response.getMessage()) // Get the message from the response and set it
                .build();

        return responseMessage.getMessage(); // Return the response message
    }
}


