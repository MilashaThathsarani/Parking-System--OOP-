package module;

public class DriverName {
    private String vehicleNumber;
    private String vehicleType;
    private String driverName;
    private String leftTime;

    public DriverName() {
    }

    public DriverName(String vehicleNumber, String vehicleType, String driverName, String leftTime) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setDriverName(driverName);
        this.setLeftTime(leftTime);
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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }
    public String toString(){
        return vehicleNumber+" "+vehicleType+" "+driverName+" "+leftTime;
    }
}
