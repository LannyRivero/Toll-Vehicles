package dev.lanny.vehicle_tollstation.tollStation;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dev.lanny.vehicle_tollstation.vehicle.Vehicle;

@Entity
@Table(name = "toll_stations")
public class TollStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalCollected = BigDecimal.ZERO;

    @OneToMany
    private List<Vehicle> registeredVehicles = new ArrayList<>();

    public TollStation() {       
    }

    public TollStation(String name, String city) {
        this.name = name;
        this.city = city;
        this.totalCollected = BigDecimal.ZERO;
        this.registeredVehicles = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public BigDecimal getTotalCollected() {
        return totalCollected;
    }

    public List<Vehicle> getRegisteredVehicles() {
        return registeredVehicles;
    } 
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTotalCollected(BigDecimal totalCollected) {
        this.totalCollected = totalCollected;
    }
}
