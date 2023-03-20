public class Person {
    
    private String code;
    private String name;
    private String Gender;
    private String dateOfBirth;
    
    
    
	public Person(String code, String name, String gender, String dateOfBirth) {
		super();
		this.code = code;
		this.name = name;
		Gender = gender;
		this.dateOfBirth = dateOfBirth;
	}
	public Person() {
	
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Code = " + code + ", Name = " + name + ", Gender = " + Gender + ", dateOfBirth = " + dateOfBirth  ;
	}

    
}

