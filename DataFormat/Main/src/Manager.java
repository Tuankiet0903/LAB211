

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Manager {

    public final Scanner sc = new Scanner(System.in);
    public final String PHONE_VALID = "^[0-9]{10}$";
    public final String EMAIL_VALID = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";

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

    public String checkInputPhone() {
        while (true) {
            try {
                int phoneCheck = Integer.parseInt(sc.nextLine());
                String resultCheck = String.valueOf(phoneCheck);
                if (!resultCheck.matches(PHONE_VALID)) {
                    System.out.println("Phone number must be 10 digits");
                } else {
                    return resultCheck;
                }
            } catch (NumberFormatException ex) {
            	System.out.println("Phone number must be number");
                System.out.print("Phone number: ");
            }
        }
    }
    
    public String checkInputDate() {
        while (true) {
        		String dateInput = checkInputString();
        		String dateFormat ="dd/MM/yyyy";
                boolean dateCheck = isValidDate(dateInput, dateFormat);
                if(dateCheck) {
                	return dateInput;
                }else {
                	 System.out.println("Date to correct format(dd/MM/yyyy)");
                     System.out.print("Date: ");
                }
        }
    }
    public boolean isValidDate(String dateStr, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateStr);
            if (!dateStr.equals(sdf.format(date))) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }	

    public String checkInputEmail() {
        while (true) {
            String emailCheck = checkInputString();
            if (!emailCheck.matches(EMAIL_VALID)) {
                System.out.println("Email must be correct format");
                System.out.print("Email: ");
            } else {
                return emailCheck;
            }
        }
    }
    
    public void displayData() {
    	System.out.print("Phone number: ");	
        String phone = checkInputPhone();
        System.out.print("Date: ");
        String date = checkInputDate();
        System.out.print("Email: ");
        String email = checkInputEmail();
        System.out.println();
        System.out.printf("%-20s%-20s%-20s\n", "Phone", "date", "Email");
    	System.out.printf("%-20s%-20s%-20s\n", phone, date, email);
    }
    

  
}
