package ATM;

class Customer {
    String name;
    String address;
    String contactInformation;
    
 // Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String CustomerDetails() {
		return "Customer name ->" + name + "\nAddress ->" + address + "\nContact Details ->" + contactInformation ;
	} 
	
}


