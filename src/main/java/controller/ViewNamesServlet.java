/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Oct 2, 2022
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllColorsServlet
 */
@WebServlet("/viewNamesServlet")
public class ViewNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewNamesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ColorNameHelper help = new ColorNameHelper();
		request.setAttribute("listNames", help.getAllNames());
		String path = "/name-list.jsp";
		if(help.getAllNames().isEmpty()) {
			path = "/add-name.jsp";
			request.setAttribute("result", "No Names have been added.");
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
