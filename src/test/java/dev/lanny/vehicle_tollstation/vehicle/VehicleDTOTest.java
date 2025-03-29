package dev.lanny.vehicle_tollstation.vehicle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleDTOTest {

    @Test
    @DisplayName("Should allow setting and getting all fields in VehicleDTO")
    void shouldSetAndGetAllFields() {
        VehicleDTO dto = new VehicleDTO();
        dto.setLicensePlate("ABC123");
        dto.setTollStationId(1L);
        dto.setType(VehicleType.TRUCK);
        dto.setAxleCount(4);

        assertEquals("ABC123", dto.getLicensePlate());
        assertEquals(1L, dto.getTollStationId());
        assertEquals(VehicleType.TRUCK, dto.getType());
        assertEquals(4, dto.getAxleCount());
    }
}



