package Servlet;

import java.util.ArrayList;
import java.util.Iterator;

public class dsSinhVien {
	private ArrayList<SinhVien> danhSach;

	public dsSinhVien(ArrayList<SinhVien> danhSach) {
		this.danhSach = danhSach;
	}
	

	public dsSinhVien() {
		this.danhSach = new ArrayList<SinhVien>();
	}


	// 1. them sinh vien
	public void themSinhVien(SinhVien sv) {
		this.danhSach.add(sv);

	}
// 2. in danh sach sinh vien
	public String inDanhSach() {
		 StringBuilder sb = new StringBuilder();
	        sb.append("<h2>Danh sách sinh viên:</h2>");
	        sb.append("<table border='1'><tr><th>Name</th><th>ID</th><th>Age</th><th>Average Score</th></tr>");
	        for (SinhVien sv : danhSach) {
	            sb.append("<tr>");
	            sb.append("<td>").append(sv.Name).append("</td>");
	            sb.append("<td>").append(sv.mssv).append("</td>");
	            sb.append("<td>").append(sv.age).append("</td>");
	            sb.append("<td>").append(sv.AverageScore).append("</td>");
	            sb.append("</tr>");
	        }
	        sb.append("</table>");
	        return sb.toString();
	}
}
