import java.util.List;

import controller.ColorNameHelper;
import controller.HexColorHelper;
import model.ColorName;
import model.HexColor;

/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Oct 1, 2022
 */

public class ColorTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HexColor aquamarine = new HexColor("7FFFD4");
		ColorName Aquamarine = new ColorName(aquamarine, "Aquamarine");
		
		HexColor gold = new HexColor("FFD700");
		ColorName Gold = new ColorName(gold, "Gold");
		ColorName Hazard = new ColorName(gold, "Hazard");
		
		HexColorHelper hh = new HexColorHelper();
		ColorNameHelper nh = new ColorNameHelper();
		
		
		hh.insertColor(aquamarine);
		hh.insertColor(gold);
		nh.insertName(Aquamarine);
		nh.insertName(Gold);
		nh.insertName(Hazard);
		
		
		List<HexColor> allColors = hh.getAllColors();
		for(HexColor n: allColors) {
			System.out.println(n.getHexColor());
		}
		List<ColorName> allNames = nh.getAllNames();
		for(ColorName n: allNames) {
			System.out.println(n.toString());
		}
		
		hh.deleteColor(gold);
		
		allColors = hh.getAllColors();
		for(HexColor n: allColors) {
			System.out.println(n.getHexColor());
		}
		allNames = nh.getAllNames();
		for(ColorName n: allNames) {
			System.out.println(n.toString());
		}
		
		hh.cleanUp();
		nh.cleanUp();
	}

}
