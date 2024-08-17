package Servlet;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dsSinhVien dssv = new dsSinhVien();
		int choice = 0;
		do {
			System.out.println("MENU");
			System.out.println("1.Them sinh vien\n" + "2.In danh sach sinh vien\n" + "0.Thoat chuong trinh");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: {
				System.out.println("Nhap ten sinh vien:");
				String name = sc.nextLine();
				System.out.println("Nhap ma sinh vien:");
				String idStudent = sc.nextLine();
				System.out.println("Nhap tuoi sinh vien");
				int age = sc.nextInt();
				System.out.println("Nhap ten diem trung binh:");
				Float averageScore = sc.nextFloat();
				SinhVien sv = new SinhVien(age, idStudent, averageScore, name);
				dssv.themSinhVien(sv);
				break;
			}
			case 2: {
				dssv.inDanhSach();
				break;
			}
			}
		} while (choice != 0);
	}
}
