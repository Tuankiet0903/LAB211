
public class PhanSoMain {
	public static void main(String[] args) {
		PhanSo ps1 = new PhanSo(3,4);
		PhanSo ps2 = new PhanSo(5,4);
		
		System.out.println(ps1.add(ps2).toString());
		System.out.println(ps1.subtract(ps2).toString());
		System.out.println(ps1.mutiply(ps2).toString());
		System.out.println(ps1.divide(ps2).toString());
		System.out.println(ps1.toString()+ps1.compare(ps2)+ps2.toString());
	}
}
