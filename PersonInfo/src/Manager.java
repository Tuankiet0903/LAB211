import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {

	private final Scanner sc = new Scanner(System.in);

	public boolean checkInterger(String str) {
		Pattern pattern = Pattern.compile("\\d*");
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public double getDouble(String msg) {
		while (true) {
			System.out.println(msg);
			String str = sc.nextLine();
			if (checkInterger(str)) {
				return Double.parseDouble(str);
			} else {
				System.out.println("Enter again");
			}
		}
	}

	public String getString(String msg) {
		System.out.println(msg);
		return sc.nextLine().trim();
	}

	public Person[] inputPersonInfo() {
		Person[] p = new Person[3];
		for (int i = 0; i < 3; i++) {
			String name = getString("Enter Name: ");
			String address = getString("Enter address: ");
			double salary = getDouble("Enter Salary: ");
			p[i] = new Person(name, address, salary);
		}
		return p;
	}

	public Person[] sortBySalary(Person[] persons) {
		Person pt;
		for (int i = 0; i < persons.length; i++) {
			for (int j = i + 1; j < persons.length; j++) {
				if (persons[i].getSalary() > persons[j].getSalary()) {
					pt = persons[i];
					persons[i] = persons[j];
					persons[j] = pt;
				}
			}
		}
		return persons;
	}

	public void displayPerson(Person[] p) {
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].toString());
		}
	}

}
