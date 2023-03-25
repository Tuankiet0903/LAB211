
public class HocVien {
	String studentId;
	String fullName;
	String yearOfBirth;
	double test1Score;
	double test2Score;
	double finalExamScore;
	
	public HocVien() {
		super();
	}

	public HocVien(String studentId, String fullName, String yearOfBirth, double test1Score, double test2Score,
			double finalExamScore) {
		super();
		this.studentId = studentId;
		this.fullName = fullName;
		this.yearOfBirth = yearOfBirth;
		this.test1Score = test1Score;
		this.test2Score = test2Score;
		this.finalExamScore = finalExamScore;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public double getTest1Score() {
		return test1Score;
	}

	public void setTest1Score(double test1Score) {
		this.test1Score = test1Score;
	}

	public double getTest2Score() {
		return test2Score;
	}

	public void setTest2Score(double test2Score) {
		this.test2Score = test2Score;
	}

	public double getFinalExamScore() {
		return finalExamScore;
	}

	public void setFinalExamScore(double finalExamScore) {
		this.finalExamScore = finalExamScore;
	}
	
	
	@Override
	public String toString() {
		return "StudentId=" + studentId + ", fullName=" + fullName + ", yearOfBirth=" + yearOfBirth
				+ ", test1Score=" + test1Score + ", test2Score=" + test2Score + ", finalExamScore=" + finalExamScore
				+ "]";
	}
	
	public double calc() {
		return ((test1Score +test2Score)/2+finalExamScore*2)/3;
	}

	public void studentClassification(double average) {
		HocVien hv = new HocVien();
		double result;
		result = average;
		if (result>=8&&result<=10) {
			System.out.println("Exellent");
		}else if(result>=7&&result<8) {
			System.out.println("Good");
		}else if(result>=5&&result<7) {
			System.out.println("Average");
		}else if(result<5) {
			System.out.println("Fail");
		}
	}
	
	public String printInfo() {
		return toString();
	}
	
	
}
