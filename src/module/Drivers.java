package module;

public class Drivers {
    private String driverName;
    private String nic;
    private String drivingLicenseNum;
    private String address;
    private int contactNum;

    public Drivers() {
    }

    public Drivers(String driverName, String nic, String drivingLicenseNum, String address, int contactNum) {
        this.setDriverName(driverName);
        this.setNic(nic);
        this.setDrivingLicenseNum(drivingLicenseNum);
        this.setAddress(address);
        this.setContactNum(contactNum);
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDrivingLicenseNum() {
        return drivingLicenseNum;
    }

    public void setDrivingLicenseNum(String drivingLicenseNum) {
        this.drivingLicenseNum = drivingLicenseNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNum() {
        return contactNum;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }
}

