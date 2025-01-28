package com.dailycodebuffer.employeeservice.config;

import com.dailycodebuffer.SalaryServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Bean
    public SalaryServiceGrpc.SalaryServiceBlockingStub salaryServiceStub() {
        // Configure the gRPC channel to communicate with salary-service
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9091)
                .usePlaintext() // Use plaintext negotiation (no SSL/TLS)
                .build();

        return SalaryServiceGrpc.newBlockingStub(channel);
    }
}
