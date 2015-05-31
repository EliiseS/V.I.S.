
package final_project_2sem;

public class Customer {
    int id;
    String fName;
    String lName;
    String address;
    String phoneNo;
    String email;    
    
    public Customer() {
        fName = "";
        lName  = "";
        address   = "";
        phoneNo   = "";
        email     = "";
    }
    public Customer(int id, String fName, String lName, String address, String phoneNo, String email){
        this.id        = id;
        this.fName     = fName;
        this.lName     = lName;
        this.address   = address;
        this.phoneNo   = phoneNo;
        this.email     = email;
    }

    public int getId() {
        return id;
    }
    
    public String getFName() {
        return fName;
    }

    public void setFName(String firstName) {
        this.fName = firstName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lastName) {
        this.lName = lastName;
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
        return "Customer{" + "id=" + id + ", firstName=" + fName + ", lastName=" + lName + ", address=" + address + ", phoneNo=" + phoneNo + ", email=" + email + '}';
    }

         
}

