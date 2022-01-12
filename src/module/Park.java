package module;

public class Park {
    private String vehicleNumber;
    private String vehicleType;
    private String slotNumber;
    private String parkedTime;

    public Park() {
    }

    public Park(String vehicleNumber, String vehicleType, String slotNumber, String parkedTime) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setSlotNumber(slotNumber);
        this.setParkedTime(parkedTime);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(String parkedTime) {
        this.parkedTime = parkedTime;
    }

    public String toString() {
        return vehicleNumber+" "+vehicleType+" "+slotNumber+" "+parkedTime;
    }
}
