package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servletQuanLySinhVien
 */
@WebServlet("/servletQuanLySinhVien")
public class servletQuanLySinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private dsSinhVien getDsSinhVien(ServletContext context) {
		dsSinhVien dssv = (dsSinhVien) context.getAttribute("dssv");
		if (dssv == null) {
			dssv = new dsSinhVien();
			context.setAttribute("dssv", dssv);
		}
		return dssv;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletQuanLySinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset = UTF-8");
		PrintWriter pw = response.getWriter();
		ServletContext context = getServletContext();
		dsSinhVien dssv = getDsSinhVien(context);
		if (request.getParameter("choice") != null) {
			String choicestr = request.getParameter("choice");
			int choice = Integer.parseInt(choicestr);
			switch (choice) {
			case 1: {
				pw.println("<form action='' method='post'>");
				pw.println("Name: <input type='text' name='name' required><br>");
				pw.println("Student ID: <input type='text' name='idStudent' required><br>");
				pw.println("Age: <input type='number' name='age' required><br>");
				pw.println("Average Score: <input type='number' step='0.01' name='averageScore' required><br>");
				pw.println("<input type='submit' value='Submit'>");
				pw.println("</form>");
				int age = Integer.parseInt(request.getParameter("age"));
				String name = request.getParameter("name");
				float avgScore = Float.parseFloat((request.getParameter("averageScore")));
				String idStudent = request.getParameter("idStudent");
				SinhVien sv = new SinhVien(age, idStudent, avgScore, name);
				pw.println("<p>Đã thêm sinh viên thành công!</p>");
				break;
			}
			case 2: {
				pw.println(dssv.inDanhSach());
				pw.println("<button onclick=\"window.location.href='?choice=9'\">Back to Menu</button>");
				break;
			}
			case 9: {
				pw.print("<html>");
				pw.println("<head><title>Servlet</title></head>");
				pw.println("<!DOCTYPE html>");
				pw.println("<head>");
				pw.print("<title>Menu Sinh Vien: </title>");
				pw.println("</head>");
				pw.println("<body>");
				pw.println("MENU");
				pw.println("<form action='' method='get'>");
				pw.println("1. Add Student<br>");
				pw.println("2. Print List Student<br>");
				pw.println("0. Quit<br>");
				pw.println("<input type ='text' name ='choice'><br>'");
				pw.print("<input type ='submit' name='submit' value='submit' required></input>");
				pw.println("</body>");
				pw.println("</html>");
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		} else {
			pw.print("<html>");
			pw.println("<head><title>Servlet</title></head>");
			pw.println("<!DOCTYPE html>");
			pw.println("<head>");
			pw.print("<title>Menu Sinh Vien: </title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("MENU");
			pw.println("<form action='' method='get'>");
			pw.println("1. Add Student<br>");
			pw.println("2. Print List Student<br>");
			pw.println("0. Quit<br>");
			pw.println("<input type ='text' name ='choice'><br>'");
			pw.print("<input type ='submit' name='submit' value='submit' required></input>");
			pw.println("</body>");
			pw.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		ServletContext context = getServletContext();
		dsSinhVien dssv = getDsSinhVien(context);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String idStudent = request.getParameter("idStudent");
		int age = Integer.parseInt(request.getParameter("age"));
		float avgScore = Float.parseFloat(request.getParameter("averageScore"));

		SinhVien sv = new SinhVien(age, idStudent, avgScore, name);
		dssv.themSinhVien(sv);
		response.sendRedirect(request.getRequestURI());
	}

}
