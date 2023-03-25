
public class HocVienMain {
	public static void main(String[] args) {
		HocVien hv1 = new HocVien("1", "Kietnehihi", "2003", 5, 5, 5);
		double avarage = hv1.calc();
		hv1.studentClassification(avarage);
		System.out.println(hv1.printInfo());
		
	}
}
