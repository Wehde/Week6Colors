package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class nameServlet
 */
@WebServlet("/nameServlet")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ColorNameHelper help = new ColorNameHelper();
		String action = request.getParameter("doThisToItem");
		String path = "/viewColorsServlet";
		if (action.equals("Delete")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("name"));
				help.deleteName(id);
			} catch (NullPointerException ex) {
				request.setAttribute("result", "Error: " + ex.getMessage());
				path = "/index.jsp";
			}	
		} else if (action.equals("Add a Color")) {
			path = "/index.jsp";		
		} else if (action.equals("Add a Name")) {
			try {
				request.setAttribute("colorToName", "");
				path = "/add-name.jsp";
			} catch (IllegalArgumentException ex) {
				request.setAttribute("result", "Error: " + ex.getMessage());
				getServletContext().getRequestDispatcher("/viewColorsServlet").forward(request, response);
			} catch (NullPointerException ex) {
				request.setAttribute("colorToName", "");
				path = "/add-name.jsp";
			}
			
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
