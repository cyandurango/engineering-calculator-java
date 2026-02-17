package resistorCalculator;

/* =============================================================================================
 * CLASS NAME		:	Terms
 * DESCRIPTION		:	A class that contains all attributes and functions of a Term
 * AUTHOR			:	Piolo Pascual Besinga
 * COPYRIGHT		:	created September 26, 2023
 * ------------------------------------------------------------------------------------------
 * REVISION HISTORY		
 * Date:				| By:							| Description:
 * ---------------------|-------------------------------|------------------------------------
 * November 27, 2023	| Cyril Andre Durango			| Added documentation for the
 * 						|								| class and each of the methods	
 * =============================================================================================
 */
public abstract class Resistors {
	protected final static String[] colorCodes = {"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Grey", "White", "Gold", "Silver"};
	protected final static double[] colorDigits = {0,1,2,3,4,5,6,7,8,9,-1,-2};
	protected final static String[] toleranceColor = {"Gold", "Silver","None"};
	protected final static double[] toleranceDigits = {0.05, 0.10, 0.20};
	
	public Resistors(){
	}
	
	public abstract double getResistance();
	public abstract double getTolerance();
	public abstract String getDigits();
	public abstract String getColors();
	public abstract double getMaximumRange();
	public abstract double getMinimumRange();
	public abstract String[] getColorsArray();
	
	
	public String getResistanceColorFromDigit(double digit) {
		for (int i = 0; i < colorDigits.length; i++) {
			if (colorDigits[i] == digit) {
				return colorCodes[i];
			}
		}
		
		return null;
	}
	
	public String getToleranceColorFromDigit(double digit) {
		for (int i = 0; i < toleranceDigits.length; i++) {
			if (toleranceDigits[i] == digit) {
				return toleranceColor[i];
			}
		}
		
		return null;
	}
	
	public double getResistanceDigitFromColor(String color) {
		for (int i = 0; i < colorCodes.length; i++) {
			if (colorCodes[i].equalsIgnoreCase(color)) {
				return colorDigits[i];
			}
		}
		
		return -1;
	}
	
	public double getToleranceDigitFromColor(String color) {
		for (int i = 0; i < toleranceColor.length; i++) {
			if (toleranceColor[i].equalsIgnoreCase(color)) {
				return toleranceDigits[i];
			}
		}
		
		return -1;
	}
	
	public String toString() {
		return 	"Resistance: " + this.getResistance() + "\n" +
				"Colors: " + this.getColors() + "\n" +
				"Digits: " + this.getDigits() + "\n" +
				"Maximum Range: " + this.getMaximumRange() + "\n" +
				"Minimum Range: " + this.getMinimumRange();
	}


}



