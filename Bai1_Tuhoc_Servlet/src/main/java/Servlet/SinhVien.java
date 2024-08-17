package Servlet;

public class SinhVien {
	int age;
	String mssv;
	Float AverageScore;
	String Name;
	public SinhVien(int age, String mssv, Float averageScore, String name) {
		super();
		this.age = age;
		this.mssv = mssv;
		AverageScore = averageScore;
		Name = name;
	}
	public SinhVien() {
		super();
	}
	@Override
	public String toString() {
		return "SinhVien [age=" + age + ", mssv=" + mssv + ", AverageScore=" + AverageScore + ", Name=" + Name + "]";
	}
	
}
