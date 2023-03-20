public class Employee extends Person {
    
	
	private String degree;

	public Employee(String code, String name, String gender, String dateOfBirth, String degree) {
		super(code, name, gender, dateOfBirth);
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return super.toString() +" Degree = " + degree;
	}
	
	
}
