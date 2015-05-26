
package final_project_2sem;

public class Customer {
    int id;
    String firstName;
    String lastName;
    String address;
    String phoneNo;
    String email;    
    
    public Customer() {
        firstName = "";
        lastName  = "";
        address   = "";
        phoneNo   = "";
        email     = "";
    }
    public Customer(int id, String firstName, String lastName, String address, String phoneNo, String email){
        this.id        = id;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.address   = address;
        this.phoneNo   = phoneNo;
        this.email     = email;
    }

    public int getId() {
        return id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNo=" + phoneNo + ", email=" + email + '}';
    }

         
}

