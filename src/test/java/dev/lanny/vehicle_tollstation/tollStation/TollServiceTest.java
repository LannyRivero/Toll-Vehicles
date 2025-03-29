package dev.lanny.vehicle_tollstation.tollStation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        TollStation station = new TollStation("Test Station", "Valencia");
        tollService.addTollStation(42L, station);
        TollStation result = tollService.getTollStation(42L);

        assertNotNull(result);
        assertEquals("Test Station", result.getName());
        assertEquals("Valencia", result.getCity());
    }

}
