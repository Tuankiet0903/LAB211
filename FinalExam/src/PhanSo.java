
public class PhanSo {
	double tuSo;
	double mauSo;
	
	public PhanSo(double tuSo, double mauSo){
		super();
		this.tuSo = tuSo;
		this.mauSo = mauSo;
	}

	public PhanSo() {
		super();
	}

	public double getTuSo() {
		return tuSo;
	}

	public void setTuSo(double tuSo) {
		this.tuSo = tuSo;
	}

	public double getMauSo() {
		return mauSo;
	}

	public void setMauSo(double mauSo) {
		this.mauSo = mauSo;
	}
	
	
	@Override
	public String toString() {
		return tuSo+"/"+mauSo;
	}

	public PhanSo add(PhanSo sub) {
		double rTuSo;
		double rMauSo;
		if(mauSo != sub.mauSo) {
			rTuSo = tuSo*sub.mauSo + mauSo*sub.tuSo;
			rMauSo = mauSo*sub.mauSo;
		}else {
			rTuSo = tuSo + sub.tuSo;
			rMauSo = mauSo;
		}
		return new PhanSo(rTuSo,rMauSo);
	}
	
	public PhanSo subtract(PhanSo sub) {
		double rTuSo;
		double rMauSo;
		if(mauSo != sub.mauSo) {
			rTuSo = tuSo*sub.mauSo - mauSo*sub.tuSo;
			rMauSo = mauSo*sub.mauSo;
		}else {
			rTuSo = tuSo - sub.tuSo;
			rMauSo = mauSo;
		}
		return new PhanSo(rTuSo,rMauSo);
	}
	public PhanSo mutiply(PhanSo sub) {
		double rTuSo;
		double rMauSo;
			rTuSo = tuSo*sub.tuSo;
			rMauSo = mauSo*sub.mauSo;
		return new PhanSo(rTuSo,rMauSo);
	}
	
	public PhanSo divide(PhanSo sub) {
		double rTuSo;
		double rMauSo;
			rTuSo = tuSo*sub.mauSo;
			rMauSo = mauSo*sub.tuSo;
		return new PhanSo(rTuSo,rMauSo);
	}
	
	
	public String compare(PhanSo sub) {
		double rTuSo;
		double rTuSo2;
		
			rTuSo = tuSo*sub.mauSo;
			rTuSo2 =sub.tuSo* mauSo;
		if(rTuSo < rTuSo2) {
			return "<";
		}else if (rTuSo > rTuSo2) {
			return ">";
		}else
			return "=";
	}

	
}
