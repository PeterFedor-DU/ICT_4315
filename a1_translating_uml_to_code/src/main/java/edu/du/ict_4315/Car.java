package edu.du.ict_4315

import java.time.LocalDate;
import java.util.Objects;

public class Car {
    private String permit;
    private LocalDate permitExpiration;
    private String license;
    private CarType type;
    private Customer owner; 

    public Car(String permit, LocalDate permitExpiration, String license, CarType type, Customer owner) {
        this.permit = permit;
        this.permitExpiration = permitExpiration;
        this.license = license;
        this.type = type;
        this.owner = owner;
    }
  
///Overloaded constructor for registering a car (with a customer and license)
    public Car(String license, CarType type, Customer owner) {
        this.permit = "P" + license; // Assigning a permit (you can customize this logic as needed)
        this.permitExpiration = LocalDate.now().plusYears(1); // Setting permit expiration (default 1 year)
        this.license = license;
        this.type = type;
        this.owner = owner;
    }

    // Getters
    public String getPermit() {
        return permit;
    }

    public String getLicense() {
        return license;
    }

    public LocalDate getPermitExpiration() {
        return permitExpiration;
    }

    public void setPermitExpiration(LocalDate permitExpiration) {
        this.permitExpiration = permitExpiration;
    }

public Object getOwner() {
		
		return owner;
	}


  
    public String toString() {
        return "Car [Permit=" + permit + ", License=" + license + ", Type=" + type + ", Owner=" + owner.getName() + "]";
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(license, car.license) && Objects.equals(owner, car.owner);
    }


   
    public int hashCode() {
        return Objects.hash(license, owner);
    }
}
