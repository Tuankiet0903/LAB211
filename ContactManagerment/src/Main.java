import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Contact> cl = new ArrayList<>();
		cl.add(new Contact(1, "Iker Casillas", "Star", "Spain", "1234567890", "Iker", "Casillas"));
		cl.add(new Contact(2, "John Terry", "Star", "England", "1234567890", "John", "Terry"));
        cl.add(new Contact(3, "Raul Gonzalez", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));
		Manager mn = new Manager();
		while(true) {
		int choice = mn.Menu();
		switch(choice) {
		case 1:
			mn.createContact(cl);
			break;
		case 2:
			mn.printAllContact(cl);
			break;
		case 3:
			mn.deleteContact(cl);
			break;
		case 4: 
			return;
		}
		}
	}
}
