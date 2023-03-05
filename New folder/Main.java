
public class Main {

	public static void main(String[] args) {
		 Manager mn = new Manager();
	     Person[] persons = new Person[3];	
	     for (int i = 0; i < persons.length; i++) {
	            persons[i] = mn.inputPersonInfo();
	     }
	     mn.sortBySalary(persons);
	     mn.displayPerson(persons);
	 }
}

