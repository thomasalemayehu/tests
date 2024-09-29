package com.tests;

public class ServiceHandler {
    private final RemoteService remoteService;

    public ServiceHandler(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    public String handleRequest(String request) {
        String data = remoteService.fetchData(request);
        return "Processed: " + data;
    }
}

