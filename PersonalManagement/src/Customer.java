public class Customer extends Person {
  
	private String customerType;

	public Customer(String code, String name, String gender, String dateOfBirth, String customerType) {
		super(code, name, gender, dateOfBirth);
		this.customerType = customerType;
	}
	

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}


	@Override
	public String toString() {
		return super.toString() + " Customer Type=" + customerType ;
	}



	
	
	
}
   
