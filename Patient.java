/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Patient class. Stores a patient's personal information,
 * address, and emergency contact information, and provides methods to
 * build formatted strings from that data and validate phone numbers.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 */
public class Patient {

    private String firstName;
    private String middleName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String emergencyContactName;
    private String emergencyContactPhone;

    // No-argument constructor. Sets every field to an empty string.
    public Patient() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.street = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phoneNumber = "";
        this.emergencyContactName = "";
        this.emergencyContactPhone = "";
    }

    // Constructor that initializes only the first, middle, and last name.
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phoneNumber = "";
        this.emergencyContactName = "";
        this.emergencyContactPhone = "";
    }

    // Constructor that initializes every attribute of the patient.
    public Patient(String firstName, String middleName, String lastName, String street,
            String city, String state, String zip, String phoneNumber,
            String emergencyContactName, String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Accessors and mutators for every field.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Builds and returns "First Middle Last".
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Builds and returns "Street City State ZIP".
    public String buildAddress() {
        return street + " " + city + " " + state + " " + zip;
    }

    // Builds and returns "EmergencyName EmergencyPhone".
    public String buildEmergencyContact() {
        return emergencyContactName + " " + emergencyContactPhone;
    }

    // Returns all patient information using the build methods above.
    @Override
    public String toString() {
        return "Patient Information\n"
                + "-------------------\n"
                + "Name: " + buildFullName() + "\n"
                + "Address: " + buildAddress() + "\n"
                + "Phone Number: " + phoneNumber + "\n"
                + "Emergency Contact: " + buildEmergencyContact();
    }

    // Returns true if the patient's phone number matches ###-###-####.
    public boolean isValidPhoneNumber() {
        if (phoneNumber == null) {
            return false;
        }
        return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    // Returns true if the emergency contact phone matches ###-###-####.
    public boolean isValidEmergencyPhoneNumber() {
        if (emergencyContactPhone == null) {
            return false;
        }
        return emergencyContactPhone.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    // Returns "Last, First Middle".
    public String getLastFirstMiddle() {
        return lastName + ", " + firstName + " " + middleName;
    }

    // Returns true if the given city and state match this patient's city and state.
    public boolean hasSameCityState(String city, String state) {
        return this.city.equalsIgnoreCase(city) && this.state.equalsIgnoreCase(state);
    }

    // Updates the patient's street, city, state, and zip in one call.
    public void updateAddress(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Returns a formatted summary of the patient and emergency contact details.
    public String getContactSummary() {
        return "Patient " + buildFullName() + " (" + phoneNumber
                + ") - Emergency Contact: " + buildEmergencyContact();
    }
}
