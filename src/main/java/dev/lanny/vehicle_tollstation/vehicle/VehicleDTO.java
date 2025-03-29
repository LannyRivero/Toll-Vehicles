package dev.lanny.vehicle_tollstation.vehicle;


public class VehicleDTO {
    private String licensePlate;
    private Long tollStationId;
    private VehicleType type;
    private Integer axleCount;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getTollStationId() {
        return tollStationId;
    }

    public void setTollStationId(Long tollStationId) {
        this.tollStationId = tollStationId;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Integer getAxleCount() {
        return axleCount;
    }

    public void setAxleCount(Integer axleCount) {
        this.axleCount = axleCount;
    }	
}
