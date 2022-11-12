package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HexColor;

/**
 * Servlet implementation class EditColorServlet
 */
@WebServlet("/editColorServlet")
public class EditColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditColorServlet() {
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
		HexColor newColor = new HexColor();
		HexColor oldColor = new HexColor();
		HexColorHelper help = new HexColorHelper();
		try {
			newColor.setHexColor(request.getParameter("newColor").toUpperCase());
			oldColor.setHexColor(request.getParameter("oldColor"));
			System.out.println(oldColor.getHexColor());
			help.updateColor(oldColor, newColor);
			request.setAttribute("result", newColor.getHexColor() + " updated");
			getServletContext().getRequestDispatcher("/viewColorsServlet").forward(request, response);
		} catch (IllegalArgumentException ex) {
			request.setAttribute("result", "Error: " + ex.getMessage());
			getServletContext().getRequestDispatcher("/viewColorsServlet").forward(request, response);
		} catch (NullPointerException ex) {
			request.setAttribute("result", "Error: Color was not selected");
			getServletContext().getRequestDispatcher("/viewColorsServlet").forward(request, response);
		}
	}
}
