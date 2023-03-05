import java.util.Scanner;

public class Manager {

	private final Scanner sc = new Scanner(System.in);
	
	 public String checkInputString() {
	     
	        while (true) {
	            String result = sc.nextLine().trim();
	            if (result.isEmpty()) {
	                System.out.println("Not empty.");
	            } else {
	                return result;
	            }
	        }
	    }

	    public double checkInputSalary() {
	        while (true) {
	            try {
	                double result = Double.parseDouble(sc.nextLine());
	                if (result < 0) {
	                    System.out.println("Salary is greater than zero");
	                } else {
	                    return result;
	                }
	            } catch (NumberFormatException ex) {
	                System.out.println("You must input digidt.");
	                System.out.print("Please input salary: ");
	            }
	        }
	    }
  
	    public Person inputPersonInfo() {
	        System.out.println("Input Information of Person");
	        System.out.print("Please input name: ");
	        String name = checkInputString();
	        System.out.print("Please input address: ");
	        String address = checkInputString();
	        System.out.print("Please input salary: ");
	        double salary = checkInputSalary();
	        return new Person(name, address, salary);
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
	    	System.out.println("\n");
			for (int i = 0; i < p.length; i++) {
				System.out.println(p[i].toString());
			}
		}
}
