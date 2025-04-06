package com.oteller.example.gateway.service;


import com.oteller.example.gateway.payload.request.AuthenticationRequest;
import com.oteller.example.gateway.payload.response.AuthenticationResponse;
import com.oteller.example.gateway.payload.request.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
