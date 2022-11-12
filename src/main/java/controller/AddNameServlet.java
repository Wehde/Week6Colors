/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Oct 2, 2022
 */
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ColorName;
import model.HexColor;

/**
 * Servlet implementation class EditColorServlet
 */
@WebServlet("/addNameServlet")
public class AddNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNameServlet() {
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
		HexColor color = new HexColor();
		ColorName colorName = new ColorName();
		ColorNameHelper help = new ColorNameHelper();
		HexColorHelper colorHelp = new HexColorHelper();
		try {
			color.setHexColor(request.getParameter("color").toUpperCase());
			
			List<HexColor> allColors = colorHelp.getAllColors();
			if(allColors.contains(color)) {
				colorName.setHexColor(color);
				colorName.setName(request.getParameter("name"));
				help.insertName(colorName);
				request.setAttribute("result", colorName.getName() + " added");
				getServletContext().getRequestDispatcher("/viewNamesServlet").forward(request, response);
			} else {
				request.setAttribute("result", color.getHexColor() + " is not in the database so it is not able to be named.");
				getServletContext().getRequestDispatcher("/add-name.jsp").forward(request, response);
			}
		} catch (IllegalArgumentException ex) {
			request.setAttribute("result", "Error: " + ex.getMessage());
			getServletContext().getRequestDispatcher("/viewNamesServlet").forward(request, response);
		} catch (NullPointerException ex) {
			request.setAttribute("result", "Error: Color was not selected");
			getServletContext().getRequestDispatcher("/viewNamesServlet").forward(request, response);
		}
	}
}

