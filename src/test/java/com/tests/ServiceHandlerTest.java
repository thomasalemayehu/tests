package com.tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ServiceHandlerTest {

    private RemoteService remoteService;
    private ServiceHandler serviceHandler;

    @Before
    public void setUp() {
        // Create a mock of the RemoteService
        remoteService = Mockito.mock(RemoteService.class);

        // Create an instance of ServiceHandler with the mocked RemoteService
        serviceHandler = new ServiceHandler(remoteService);
    }

    @Test
    public void testHandleRequestSuccess() {
        // Mock the behavior of the remote service for a specific input
        when(remoteService.fetchData("request1")).thenReturn("data1");

        // Call the method being tested
        String result = serviceHandler.handleRequest("request1");

        // Verify the result
        assertEquals("Processed: data1", result);

        // Verify that the remote service was called with the correct parameter
        verify(remoteService).fetchData("request1");
    }

    @Test
    public void testHandleRequestFailure() {
        // Mock the behavior of the remote service returning null or an empty response
        when(remoteService.fetchData("request2")).thenReturn(null);

        // Call the method being tested
        String result = serviceHandler.handleRequest("request2");

        // Verify the result
        assertEquals("Processed: null", result);

        // Verify that the remote service was called with the correct parameter
        verify(remoteService).fetchData("request2");
    }
}
