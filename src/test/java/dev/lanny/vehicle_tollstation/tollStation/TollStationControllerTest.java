package dev.lanny.vehicle_tollstation.tollStation;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.lanny.vehicle_tollstation.vehicle.Vehicle;
import dev.lanny.vehicle_tollstation.vehicle.VehicleType;

public class TollStationControllerTest {
    private MockMvc mockMvc;
    private Vehicle vehicle;

    @Mock
    private TollStation tollStation;

    @InjectMocks
    private TollStationController tollStationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tollStationController).build();
        vehicle = new Vehicle("ABC123", new BigDecimal("100.00"), VehicleType.CAR);
    }

    @Test
    @DisplayName("Validate collect toll from vehicle and return 200 OK")
    void test_Should_Collect_Toll_Successfully() throws Exception {
       
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/toll")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(vehicle)))
                .andExpect(status().isOk());

        verify(tollStation, times(1)).addVehicle(any());
    }

}
