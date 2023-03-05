
public class Main {
public static void main(String[] args) {
	Manager mn = new Manager();
	while(true) {
	int choice = mn.Menu();
	switch(choice) {
	case 1:
		mn.normalCal();
		break;
	case 2:
		mn.BMICal();
		break;
	case 3: 
		return;
	}
	}
}
}
