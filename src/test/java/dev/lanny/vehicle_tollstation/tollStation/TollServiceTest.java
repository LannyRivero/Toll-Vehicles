package dev.lanny.vehicle_tollstation.tollStation;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.lanny.vehicle_tollstation.vehicle.Vehicle;
import dev.lanny.vehicle_tollstation.vehicle.VehicleDTO;
import dev.lanny.vehicle_tollstation.vehicle.VehicleType;

public class TollServiceTest {

    private TollService tollService = new TollService();

    @BeforeEach
    void setUp() {
        tollService = new TollService();
        TollStation station = new TollStation("Main Station", "Seville");
        tollService.addTollStation(1L, station);
    }

    @Test
    @DisplayName("Validate return TollStation by ID")
    void test_Should_Return_TollStation_By_Id() {

        TollStation result = tollService.getTollStation(1L);

        assertNotNull(result);
        assertEquals("Main Station", result.getName());
        assertEquals("Seville", result.getCity());
    }

    @Test
    @DisplayName("Validate return correct toll amount for registered car")
    void test_Should_Return_Correct_Toll_Amount_For_Car() {
        VehicleDTO dto = new VehicleDTO();
        dto.setLicensePlate("CAR123");
        dto.setType(VehicleType.CAR);
        dto.setTollStationId(1L);

        Vehicle vehicle = tollService.registerVehicle(dto);

        assertEquals(new BigDecimal("100.00"), vehicle.getTollAmount());
    }

    @Test
    @DisplayName("VAlidate throw exception for unknown vehicle type")
    void test_Should_Throw_Exception_For_Unknown_Type() {
        VehicleDTO dto = new VehicleDTO();
        dto.setLicensePlate("FAIL001");
        dto.setTollStationId(1L);
        dto.setType(null);

        assertThrows(IllegalArgumentException.class, () -> {
            tollService.registerVehicle(dto);
        });
    }

    @Test
    @DisplayName("Validate calculate toll for truck using axle count (4 axles = $200)")
    void test_Should_Calculate_Toll_For_Truck_Correctly() {
        VehicleDTO dto = new VehicleDTO();
        dto.setLicensePlate("TRK888");
        dto.setType(VehicleType.TRUCK);
        dto.setTollStationId(1L);
        dto.setAxleCount(4);

        Vehicle vehicle = tollService.registerVehicle(dto);

        BigDecimal expected = BigDecimal.valueOf(200L).setScale(2);
        BigDecimal actual = vehicle.getTollAmount().setScale(2);

        assertEquals(0, actual.compareTo(expected));
    }
}
