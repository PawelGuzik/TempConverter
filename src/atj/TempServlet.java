package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TempServlet
 */
@WebServlet(description = "Servlet konwertera temperatury", urlPatterns = { "/TempServlet" })
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double temp;
	String skala;
	double convTemp;
	String resultTemp;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		getAttributes(request);
		calculateTemp(temp, skala);
		request.setAttribute("result", String.format("%.2f", convTemp) + " "+"<sup>o</sup>" + resultTemp);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("TempConverter.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	private void getAttributes(HttpServletRequest request) {
		temp = Double.parseDouble(request.getParameter("tempValue"));
		
		skala = request.getParameter("skale");
	}
	 private void calculateTemp(double temp, String skala) {
		 if(skala.equalsIgnoreCase("C")) {
			 convTemp = temp-273.15;
			 resultTemp = "F";
		 }else if(skala.equalsIgnoreCase("F")) {
			 convTemp = temp+273.15;
			 resultTemp = "C";
		 }
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
