package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HexColor;

/**
 * Servlet implementation class menuServlet
 */
@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
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
		HexColor hexColor = new HexColor();
		HexColorHelper help = new HexColorHelper();
		String action = request.getParameter("doThisToItem");
		String path = "/viewColorsServlet";
		if (action.equals("Delete")) {
			try {
				String hex = request.getParameter("color").toUpperCase();
				hexColor.setHexColor(hex);
				help.deleteColor(hexColor);
			} catch (IllegalArgumentException ex) {
				request.setAttribute("result", "Error: " + ex.getMessage());
				path = "/index.jsp";
			}	
		} else if (action.equals("Edit")) {
			try {
				String hex = request.getParameter("color").toUpperCase();
				hexColor.setHexColor(hex);
				request.setAttribute("colorToEdit", hexColor);
				path = "/editColor.jsp";
			} catch (IllegalArgumentException ex) {
				request.setAttribute("result", "Error: " + ex.getMessage());
				getServletContext().getRequestDispatcher("/viewColorsServlet").forward(request, response);
			} catch (NullPointerException ex) {
				request.setAttribute("result", "Error: Color was not selected");
				getServletContext().getRequestDispatcher("/viewColorsServlet").forward(request, response);
			}
		} else if (action.equals("Add a Color")) {
			path = "/index.jsp";
		} else if (action.equals("Add Color")) {
			String color = request.getParameter("color").toUpperCase();
			try {
				hexColor.setHexColor(color);
				List<HexColor> allColors = help.getAllColors();
				if(allColors.contains(hexColor)) {
					request.setAttribute("result", color + " is already in the database. Unable to add.");
				} else {
					help.insertColor(hexColor);
					request.setAttribute("result", hexColor.getHexColor() + " added");
				}
				path = "/index.jsp";
			} catch (IllegalArgumentException ex){
				request.setAttribute("result", "Error: " + ex.getMessage());
				path = "/index.jsp";
			}
		} else if (action.equals("View Similar Colors")) {
			String color = request.getParameter("color").toUpperCase();
			try {
				hexColor.setHexColor(color);
				List<HexColor> allColors = help.getAllColors();
				if(allColors.contains(hexColor)) {
					request.setAttribute("gray", hexColor.getHexGray());
					request.setAttribute("some", true);
					path = "/viewColorsServlet";
				} else {
					help.insertColor(hexColor);
					request.setAttribute("result", color + " is not in the database");
					path = "/index.jsp";
				}		
			} catch (IllegalArgumentException ex){
				request.setAttribute("result", "Error: " + ex.getMessage());
				path = "/index.jsp";
			}
			
		} else if (action.equals("Add a Name")) {
			try {
				String hex = request.getParameter("color").toUpperCase();
				hexColor.setHexColor(hex);
				request.setAttribute("colorToName", hexColor.getHexColor());
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
