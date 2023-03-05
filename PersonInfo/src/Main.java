
public class Main {

	public static void main(String[] args) {
		Person[] persons = new Person[3];
		Manager mn = new Manager();
		persons = mn.inputPersonInfo();
		persons = mn.sortBySalary(persons);
		mn.displayPerson(persons);

	}
}
