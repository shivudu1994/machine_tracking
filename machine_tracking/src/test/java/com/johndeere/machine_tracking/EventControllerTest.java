package com.johndeere.machine_tracking;

import com.johndeere.machine_tracking.controller.EventController;
import com.johndeere.machine_tracking.service.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(EventController.class)
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Test
    void testGetAggregatedEventsBySessionId() throws Exception {
        when(eventService.getAggregatedEventsBySessionId(anyString())).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/aggregated")
                        .param("sessionId", "testSessionId"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void testGetAggregatedEventsByMachineId() throws Exception {
        when(eventService.getAggregatedEventsByMachineId(anyString())).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/aggregated")
                        .param("machineId", "testMachineId"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void testInvalidRequest() throws Exception {
        mockMvc.perform(get("/aggregated"))
                .andExpect(status().isBadRequest());
    }
}
