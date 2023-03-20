import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

	public final Scanner sc = new Scanner(System.in);
	
	ArrayList<Employee> le = new ArrayList<>();
	ArrayList<Customer> lc = new ArrayList<>();
	
	public String checkString() {	
		while(true) {
			String result = sc.nextLine();
			if(result.length()==0||result.isEmpty()) {
				System.out.println("Not Empty!");
				System.out.print("Enter again: ");
			}else
				return result;
		}
	}
	
	
	
	public String generateEmpCode(String key,ArrayList<Employee> le) {
		String id ="1";
		if(le.size()==0) {
			return key+id;
		}else {
			for(Employee e : le) {
				if(e.getCode().length() == le.size()) {
					int idTemp = Integer.parseInt(e.getCode());
					id =key+(idTemp	+1);
				}
			}
		}
		return id;
	}
	public String generateCusCode(String key,ArrayList<Customer> lc) {
		String id ="1";
		if(lc.size()==0) {
			return key+id;
		}else {
			for(Customer c : lc) {
				if(c.getCode().length() == lc.size()) {
					int idTemp = Integer.parseInt(c.getCode());
					id =key+(idTemp+1);
				}
			}
		}
		return id;
	}
	
	public String checkGender() {
		while(true) {
			String result = checkString();
			if(result.matches("(?:male|female)$")) {
				return result;
			}else
				System.out.print("Enter again: ");
		}
	}
	public String checkDegree() {
		while(true) {
			String result = checkString();
			if(result.matches("(?:university|college|internative)$")) {
				return result;
			}else
			System.out.print("Enter again: ");
		}
	}
	
	public String checkType() {
		while(true) {
			String result = sc.nextLine().trim();
			if(result.matches("(?:new|member|vip)$")) {
				return result;
			}else
				System.out.print("Enter again: ");
		}
	}
	
	public String checkDateOfBirth() {
		while(true) {
			String result = sc.nextLine().trim();
			if (result.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                return result;
            } else {
                System.out.println("Birthdate must have length of 10");
            }
		}
	}
	
	public  void displayEmp(ArrayList<Employee> le) {
        if (le.isEmpty()) {
            System.err.println("List empty.");
            return;
        }

        for (Employee e : le) {
            e.toString();
        }
        
    }public  void displayCus(ArrayList<Customer> lc) {
        if (lc.isEmpty()) {
            System.err.println("List empty.");
            return;
        }

        for (int i = 0; i < lc.size(); i++) {
        	System.out.println(lc.get(i));
        }
    }
	
	
	
	public void addEmployee(ArrayList<Employee> le) {
		String code = generateEmpCode("e", le);
		System.out.println("Enter Name: ");
		String name = checkString();
		System.out.println("Enter Gender: ");
		String gender = checkGender();
		System.out.println("Enter Date of Birth: ");
		String dateOfBirth = checkDateOfBirth();
		System.out.println("Enter Degree: ");
		String degree = checkDegree();
		
		le.add(new Employee(code, name, gender, dateOfBirth, degree));
	}
	public void addCustomer(ArrayList<Customer> lc) {
		String code = generateCusCode("c", lc);
		System.out.println("Enter Name: ");
		String name = checkString();
		System.out.println("Enter Gender: ");
		String gender = checkGender();
		System.out.println("Enter Date of Birth: ");
		String dateOfBirth = checkDateOfBirth();
		System.out.println("Enter Type: ");
		String type = checkType();
		
		lc.add(new Customer(code, name, gender, dateOfBirth, type));
				
		
	}

	public void countStatic(ArrayList<Customer> lc) {
        int countN = 0;
        int countM = 0;
        int countV = 0;
        for (Customer cus : lc) {
            if (cus.getCustomerType().matches("new")) {
                countN++;
            }
            if (cus.getCustomerType().matches("member")) {
                countM++;
            }
            if (cus.getCustomerType().matches("vip")) {
                countV++;
            }

        }

        System.out.println("New customer: " + countN);
        System.out.println("Member customer: " + countM);
        System.out.println("Vip customer: " + countV);

    }
	public String Menu() {
		String choice;
	
		System.out.println("1. Add Employee (enter: ae)");
		System.out.println("2. Add Customer (enter: ac)");
		System.out.println("3. Display Employee Infomation (enter: dae)");
		System.out.println("4. Display Customer Information (enter: dac)");
		System.out.println("5. Customer Static (enter: cs)");
		System.out.println("6. Exit The Program (enter: ea)");
		choice = checkString();	
		return choice;
	}
	
	public void display() {
		do {
			String choice = Menu();
		switch(choice) {
			case "ae" :
				addEmployee(le);
				break;
			case "ac" :
				addCustomer(lc);
				break;
			case "dae" :
				displayEmp(le);
				break;
			case "dac" :
				displayCus(lc);
				break;
			case "cs" :
				countStatic(lc);
				break;
			case "ea" :
				System.out.println("Do you want to exit the program (y/n)?");
                String c= sc.nextLine();
                if(c.equals("y")){
                    System.exit(0);}
                break;
		}
	}while(true);
	

	}
		
}
