package resistorCalculator;

public class FourBandResistor extends Resistors{
	private double[] colorDigits = new double[4];
	private String[] colorCodes = new String[4];
	private double resistance = 0;
	private double tolerance = 0;
	
	public FourBandResistor() { 
	}
	
	public FourBandResistor(double resistance, double tolerance){
		this.resistance = resistance;
		this.tolerance = tolerance;
		this.setColorUsingDigits(resistance, tolerance);
	}
	
	public FourBandResistor(double resistance){
		this.resistance = resistance;
		this.setColorUsingDigits(resistance);
	}
	
	public FourBandResistor(String[] newColorCodes){
		this.colorCodes = newColorCodes;
		this.setDigitsUsingColor(newColorCodes);
	}
	
	public void setDigitsUsingResistance(double newResistance, double tolerance) {
		colorDigits[3] = tolerance;
		this.tolerance = colorDigits[3];
		if (newResistance > 10) {
			int count = 0;
			while (newResistance >= 100) {
				newResistance = newResistance/10;
				count++;
			}
			
			colorDigits[2] = count;
			colorDigits[1] = newResistance%10;
			colorDigits[0] = (newResistance - colorDigits[1])/10;
			return;
		}
		else if (newResistance <= 10) {
			int count = 0;
			while (newResistance < 10) {
				newResistance = newResistance*10;
				count++;
			}
			
			colorDigits[2] = 0 - count;
			colorDigits[1] = newResistance%10;
			colorDigits[0] = (newResistance - colorDigits[1])/10;
			return;
		}
	}
	
	public void setColorUsingDigits(double resistance) {
		this.setDigitsUsingResistance(resistance, 0.20);
		for(int i = 0; i < colorDigits.length-1; i++) {
			colorCodes[i] = super.getResistanceColorFromDigit(colorDigits[i]);
		}
		
		colorCodes[3] = super.getToleranceColorFromDigit(colorDigits[3]);
	}
	
	public void setColorUsingDigits(double resistance, double tolerance) {
		this.setDigitsUsingResistance(resistance, tolerance);
		for(int i = 0; i < colorDigits.length-1; i++) {
			colorCodes[i] = super.getResistanceColorFromDigit(colorDigits[i]);
		}
		
		colorCodes[3] = super.getToleranceColorFromDigit(colorDigits[3]);
	}
	
	public void setDigitsUsingColor(String[] newColorCodes) {
		colorCodes = newColorCodes;
		for(int i = 0; i < colorCodes.length-1; i++) {
			colorDigits[i] = super.getResistanceDigitFromColor(colorCodes[i]);
		}
		
		colorDigits[3] = super.getToleranceDigitFromColor(colorCodes[3]);
		this.tolerance = colorDigits[3];
	}
	
	public String getDigits(){		
		String digits = "";
		for(int i = 0; i < colorDigits.length; i++) {
			digits = digits + colorDigits[i] + "\t";
		}
		return digits;
		
	}
	
	public String getColors(){		
		String colors = "";
		for(int i = 0; i < colorCodes.length; i++) {
			colors = colors + colorCodes[i] + "\t";
		}
		return colors;
	}
	
	public String[] getColorsArray() {
		return this.colorCodes;
	}
	
	public double getResistance() {
		if (this.resistance != 0) {
			return this.resistance;
		}
		
		return (colorDigits[0]*10+colorDigits[1])*Math.pow(10, colorDigits[2]);
	}
	
	public double getTolerance() {
		if (this.tolerance != 0) {
			return this.tolerance;
		}
		
		return colorDigits[3];
	}
	
	public double getMaximumRange() {
		return this.getResistance() + this.getResistance()*this.tolerance;
	}
	
	public double getMinimumRange() {
		return this.getResistance() - this.getResistance()*this.tolerance;
	}
	
}
