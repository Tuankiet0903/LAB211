import java.util.ArrayList;
import java.util.Scanner;


public class Manager {
private final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
	
Scanner sc = new Scanner(System.in);
	
	public int Menu() {
		int choice;
		do {
		System.out.println("======Contact Program======");
		System.out.println("1. Add a contact");
		System.out.println("2. Display all contact");
		System.out.println("3. Delete a contact");
		System.out.println("4. Exit");
		System.out.println("Enter choice: ");
		choice = Integer.parseInt(sc.nextLine());
		}
		while(choice<0&&choice>4);
		return choice;
	}
	
	public int generateID(ArrayList<Contact> cl) {
		int id = 0;
		if(cl.size()==0) {
			return 1;
		}else {
			for(Contact s :cl) {
				if (s.getId() == cl.size()) {
					id = s.getId()+1;
				}
			}
		}
		return id;
	}
	
	
	public void createContact(ArrayList<Contact> cl) {
		int id =generateID(cl);
		String firstName = getLine("Enter First Name: ");
		String lastName = getLine("Enter Last Name: ");
		String group = getLine("Enter Group: ");
		String address = getLine("Enter Address: ");
		String phone = checkInputPhone("Enter Phone: ");
		cl.add(new Contact(id,firstName+lastName,group,address,phone,firstName,lastName));	
		System.out.println("Add successful!");
	}
	
	public  void printAllContact(ArrayList<Contact> cl) {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        //print 
        for (Contact contact : cl) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }
	
	public void deleteContact(ArrayList<Contact> cl) {
		System.out.println("Enter id: ");
		int idDelete = Integer.parseInt(sc.nextLine());
		Contact contactDelete = getContactById(cl, idDelete);
		if(contactDelete == null) {
			System.out.println("Not Found!");
			return;
		}else {
			cl.remove(contactDelete);
		}
		System.out.println("Delete successful!");
	}

	
	public Contact getContactById(ArrayList<Contact> cl, int idDelete) {
        for (Contact contact : cl) {
            if (contact.getId() == idDelete) {
                return contact;
            }
        }
        return null;
    }
	public String getLine(String msg) {
		System.out.println(msg);
		return sc.nextLine().trim();
	}
	

	public  String checkInputPhone(String msg) {
		System.out.println(msg);
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_PHONE)) {
                return result;
            }
            System.err.println("Please input Phone flow\n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");
            System.out.print("Enter again: ");
        }
    }
	  public String checkInputString() {
	        
	        while (true) {
	            String result = sc.nextLine().trim();
	            if (result.isEmpty()) {
	                System.err.println("Not empty");
	                System.out.print("Enter again: ");
	            } else {
	                return result;
	            }
	        }
	    }

}

