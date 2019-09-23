package APP2019;

public class Driver {
    String id=null;
    String firstName;
    String middleName;
    String lastName;
    String emailId;
    String password;
    String phoneNumber;
    String address1;
    String address2;
    String city;
    String state;
    String country;
    String postalCode;
    Integer rating;
    Integer drivingLicenseNumber;
    String dlIssuedState;

    public Driver(String firstName, String middleName, String lastName, String emailId, String password, String phoneNumber, String address1, String address2, String city, String state, String country,String postalCode, Integer rating, Integer drivingLicenseNumber, String dlIssuedState) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.rating = rating;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.dlIssuedState = dlIssuedState;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(Integer drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }
}