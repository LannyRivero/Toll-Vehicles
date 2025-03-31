package dev.lanny.vehicle_tollstation.vehicle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VehicleTypeTest {

    @Test
    @DisplayName("Validate contain all valid vehicle types: CAR, MOTORCYCLE, TRUCK")
    void test_Should_Contain_All_Vehicle_Types() {
        assertNotNull(VehicleType.valueOf("CAR"));
        assertNotNull(VehicleType.valueOf("MOTORCYCLE"));
        assertNotNull(VehicleType.valueOf("TRUCK"));
    }

}
