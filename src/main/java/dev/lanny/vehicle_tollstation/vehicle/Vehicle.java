package dev.lanny.vehicle_tollstation.vehicle;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tollAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleType type;

    public Vehicle() {      
    }

    public Vehicle(String licensePlate, BigDecimal tollAmount, VehicleType type) {
        this.licensePlate = licensePlate;
        this.tollAmount = tollAmount;
        this.type = type;
    }

  
    public Long getId() { return id; 
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public BigDecimal getTollAmount() {
        return tollAmount;
    }

    public VehicleType getType() {
        return type;
    }    

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setTollAmount(BigDecimal tollAmount) {
        this.tollAmount = tollAmount;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
