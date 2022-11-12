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
@WebServlet("/viewColorsServlet")
public class ViewColorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewColorsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HexColorHelper help = new HexColorHelper();
		try {
			request.getAttribute("gray");
			request.setAttribute("listColors", help.searchForItemByHexGray(request.getAttribute("gray").toString()));		
		} catch (NullPointerException ex) {
			request.setAttribute("listColors", help.getAllColors());
		}

		request.setAttribute("result", "");
		String path = "/color-list.jsp";
		if(help.getAllColors().isEmpty()) {
			path = "/index.jsp";
			request.setAttribute("result", "No Colors have been added.");
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
