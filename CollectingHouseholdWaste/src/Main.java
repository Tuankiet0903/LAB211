public class Main {
    public static void main(String[] args) {
        Validation v = new Validation();
        int[] garbageAmounts = v.validateInput();
        Manager mn = new Manager();
        double totalCost = mn.calculateCost(garbageAmounts);
        mn.format(totalCost);

    }
}