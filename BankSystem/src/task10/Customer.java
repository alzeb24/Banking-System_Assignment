package task10;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String address;

    // Default constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(int customerId, String firstName, String lastName, String emailAddress, String phoneNumber, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        setEmailAddress(emailAddress);
        setPhoneNumber(phoneNumber);
        this.address = address;
    }

    // Getters and setters
    public int getCustomerId() {
    	return customerId; 
    	}
    public void setCustomerId(int customerId) {
    	this.customerId = customerId; 
    	}
    
    public String getFirstName() {
    	return firstName; 
    	}
    public void setFirstName(String firstName) { 
    	this.firstName = firstName; 
    	}

    public String getLastName() { 
    	return lastName; 
    	}
    public void setLastName(String lastName) { 
    	this.lastName = lastName; 
    	}

    public String getEmailAddress() { 
    	return emailAddress; 
    	}
    public void setEmailAddress(String emailAddress) {
        if (emailAddress.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            this.emailAddress = emailAddress;
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    public String getPhoneNumber() { 
    	return phoneNumber; 
    	}
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public void printDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + emailAddress);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Address: " + address);
    }
}

