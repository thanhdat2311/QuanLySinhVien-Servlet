package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletCong2So
 */
@WebServlet("/servletCong2So")
public class servletCong2So extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCong2So() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.println("<head><title>Servlet</title></head>");
		pw.println("<!DOCTYPE html>");
		pw.println("<head>");
		pw.print("<title>Cong 2 so</title>");
		pw.println("</head>");
		pw.println("<body>");
			pw.println("<form action='' method='post'>");
			pw.println("<h1>cộng 2 số</h1>");
			pw.println("<p><label>Số a:</label><input type='text' name='soA'</input></p>");
			pw.println("<p><label>Số b:</label><input type='text' name='soB'</input></p>");
			pw.println("<input type='submit' name='dat' value='cong'></input>");
		pw.println("</body>");
		pw.println("</html>");
	};
	 		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset = UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		if("cong".equals(request.getParameter("dat"))){
			double a,b;
			a = Double.parseDouble(request.getParameter("soA"));
			b = Double.parseDouble(request.getParameter("soB"));
			pw.println("<p><h1>kết quả:"+ String.format("%.1f + %.1f = %.1f",a,b,a+b)+"</h1></p>");}
		else {
		pw.println("<h4>tham so goi den khac value </h4>");
		}
	}

}
