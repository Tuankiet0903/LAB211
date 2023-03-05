import java.util.Scanner;


public class Manager {
	Scanner sc = new Scanner(System.in);
	
	public int Menu() {
		int choice;
		do {
		System.out.println("======Calculator Program======");
		System.out.println("1. Normal caculator");
		System.out.println("2. BMI Calculator");
		System.out.println("3. Exit");
		System.out.println("Enter choice: ");
		choice = Integer.parseInt(sc.nextLine());
		}
		while(choice<0&&choice>3);
		return choice;
	}
	
	public double checkInputDouble() {
        //loop until user input correct
        while (true) {
            try {
                double input = Double.parseDouble(sc.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }
	public double checkInput() {
		System.out.println("Enter Number: ");
		double num = checkInputDouble();
		return num;
	}
	
	public String checkOperator() {
		String input = sc.nextLine();
		if (!input.equalsIgnoreCase("+")||input.equalsIgnoreCase("-")||input.equalsIgnoreCase("*")||
			input.equalsIgnoreCase("/")||input.equalsIgnoreCase("^")||input.equalsIgnoreCase("="))
			System.out.println("Please input (+, -, *, /, ^)");
		return input;
		
	}
	
	public void normalCal() {
		double memory;
		System.out.println("Enter Number: ");
		memory = checkInputDouble();
		while(true) {	
		System.out.println("Enter Operator: ");
		String operator = checkOperator();
		if (operator.equalsIgnoreCase("+")) {
				memory += checkInput();
				System.out.println("Memory: "+memory);
			}
		if (operator.equalsIgnoreCase("+")) {
			memory += checkInput();
			System.out.println("Memory: "+memory);
		}
		if (operator.equalsIgnoreCase("-")) {
			memory -= checkInput();
			System.out.println("Memory: "+memory);
		}
		if (operator.equalsIgnoreCase("*")) {
			memory *= checkInput();
			System.out.println("Memory: "+memory);
		}
		if (operator.equalsIgnoreCase("/")) {
			memory /= checkInput();
			System.out.println("Memory: "+memory);
		}
		if (operator.equalsIgnoreCase("^")) {
			memory =Math.pow(memory, checkInput());
			System.out.println("Memory: "+memory);
		}
		if (operator.equalsIgnoreCase("=")) {
			System.out.println("Memory: "+memory);
			return;
		}
		}
	}
	
	public void BMICal() {
		System.out.println("Enter weight: ");
		double weight = checkInputDouble();
		System.out.println("Input height(cm):");
		double height=checkInputDouble();
		height=height/100;
		double bmi =weight/(height*height);
		System.out.printf("BMI number = %.2f\n",bmi);
		System.out.println("BMI status: "+BMIStatus(bmi));
	}
	public String BMIStatus(double bmi) {
		if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }	
		
	}
	
	
	
	
	
	
	
}
