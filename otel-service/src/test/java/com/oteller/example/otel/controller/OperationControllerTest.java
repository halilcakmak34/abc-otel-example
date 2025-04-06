package com.oteller.example.otel.controller;

import com.google.gson.Gson;
import com.oteller.example.otel.constant.EndPointConstant;
import com.oteller.example.otel.exception.UpdateHotelNotExistException;
import com.oteller.example.otel.exception.UpdateRoomNotExistException;
import com.oteller.example.otel.payload.dto.RoomDto;
import com.oteller.example.otel.payload.response.OperationResponse;
import com.oteller.example.otel.service.HelpService;
import com.oteller.example.otel.service.OperationService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.oteller.example.otel.TestDataPool;
import com.oteller.example.otel.payload.dto.HotelDto;
import com.oteller.example.otel.payload.request.OperationRequest;

import java.util.ArrayList;

public class OperationControllerTest {

    @InjectMocks
    private OperationController operationController;

    @Mock
    private OperationService operationService;

    @Mock
    private HelpService helpService;

    private MockMvc mockMvc;

    private final Gson gson = new Gson();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(operationController).build();
    }

    @Test
    public void testAddHotel() throws Exception{
        OperationRequest request = TestDataPool.createOperationRequest();
        String requestBodyJson = gson.toJson(request);
        String endPoint = EndPointConstant.OPERATION_PREFIX+EndPointConstant.HOTEL_PREFIX+EndPointConstant.ADD;
        Mockito.when(operationService.createHotel(Mockito.any(HotelDto.class))).thenReturn(Boolean.TRUE);
        Mockito.doNothing().when(helpService).addOperationMsgForSuccess(Mockito.any(OperationResponse.class));
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        Assert.assertNotNull(responseMessage);
    }

    @Test
    public void testAddRoom() throws Exception {
        OperationRequest request = TestDataPool.createOperationRequest();
        String requestBodyJson = gson.toJson(request);
        String endPoint = EndPointConstant.OPERATION_PREFIX+EndPointConstant.ROOM_PREFIX+EndPointConstant.ADD;
        Mockito.when(operationService.createRoom(Mockito.any(RoomDto.class))).thenReturn(Boolean.TRUE);
        Mockito.doNothing().when(helpService).addOperationMsgForSuccess(Mockito.any(OperationResponse.class));
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        Assert.assertNotNull(responseMessage);
    }

    @Test
    public void testUpdateRoom() throws Exception, UpdateRoomNotExistException {
        OperationRequest request = TestDataPool.createOperationRequest();
        request.getRoomDto().setId("1");
        String requestBodyJson = gson.toJson(request);
        String endPoint = EndPointConstant.OPERATION_PREFIX+EndPointConstant.ROOM_PREFIX+EndPointConstant.UPDATE;
        Mockito.when(operationService.updateRoom(Mockito.any(RoomDto.class))).thenReturn(Boolean.TRUE);
        Mockito.doNothing().when(helpService).addOperationMsgForSuccess(Mockito.any(OperationResponse.class));
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        Assert.assertNotNull(responseMessage);
    }

    @Test
    public void testUpdateHotel() throws Exception, UpdateHotelNotExistException {
        OperationRequest request = TestDataPool.createOperationRequest();
        request.getHotelDto().setId("1");
        String requestBodyJson = gson.toJson(request);
        String endPoint = EndPointConstant.OPERATION_PREFIX+EndPointConstant.HOTEL_PREFIX+EndPointConstant.UPDATE;
        Mockito.when(operationService.updateHotel(Mockito.any(HotelDto.class))).thenReturn(Boolean.TRUE);
        Mockito.doNothing().when(helpService).addOperationMsgForSuccess(Mockito.any(OperationResponse.class));
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        Assert.assertNotNull(responseMessage);
    }


    @Test
    public void testActionHotel() throws Exception {
        OperationRequest request = TestDataPool.createOperationRequest();
        request.getHotelDto().setId("1");
        request.setHotelDtoList(new ArrayList<>());
        request.getHotelDtoList().add(request.getHotelDto());
        request.getHotelDtoList().add(request.getHotelDto());
        String requestBodyJson = gson.toJson(request);
        String endPoint = EndPointConstant.OPERATION_PREFIX+EndPointConstant.ACTION_HOTEL;
        Mockito.when(operationService.createHotel(Mockito.any(HotelDto.class))).thenReturn(Boolean.TRUE);
        Mockito.doNothing().when(helpService).addOperationMsgForSuccess(Mockito.any(OperationResponse.class));
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        Assert.assertNotNull(responseMessage);
    }

    @Test
    public void testActionRoom() throws Exception {
        OperationRequest request = TestDataPool.createOperationRequest();
        request.getRoomDto().setId("1");
        request.setRoomDtoList(new ArrayList<>());
        request.getRoomDtoList().add(request.getRoomDto());
        request.getRoomDtoList().add(request.getRoomDto());
        String requestBodyJson = gson.toJson(request);
        String endPoint = EndPointConstant.OPERATION_PREFIX+EndPointConstant.ACTION_ROOM;
        Mockito.when(operationService.createRoom(Mockito.any(RoomDto.class))).thenReturn(Boolean.TRUE);
        Mockito.doNothing().when(helpService).addOperationMsgForSuccess(Mockito.any(OperationResponse.class));
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(endPoint).content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        Assert.assertNotNull(responseMessage);
    }

}