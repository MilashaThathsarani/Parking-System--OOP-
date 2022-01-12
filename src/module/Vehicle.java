package module;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    private int maximumWeight;
    private int noOfPassengers;

    public Vehicle() {
    }

    public Vehicle(String vehicleNumber, String vehicleType, int maximumWeight, int noOfPassengers) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setMaximumWeight(maximumWeight);
        this.setNoOfPassengers(noOfPassengers);
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

    public int getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(int maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }
    public String toString(){
        return vehicleNumber+" "+vehicleNumber+" "+maximumWeight+" "+noOfPassengers;
    }
}
