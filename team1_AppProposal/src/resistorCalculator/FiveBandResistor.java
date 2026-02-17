package resistorCalculator;

public class FiveBandResistor extends Resistors{
	private double[] colorDigits = new double[5];
	private String[] colorCodes = new String[5];
	private double resistance = 0;
	private double tolerance = 0;
	
	public FiveBandResistor() { 
	}
	
	public FiveBandResistor(double resistance, double tolerance){
		this.resistance = resistance;
		this.tolerance = tolerance;
		this.setColorUsingDigits(resistance, tolerance);
	}
	
	public FiveBandResistor(double resistance){
		this.resistance = resistance;
		this.setColorUsingDigits(resistance);
	}
	
	public FiveBandResistor(String[] newColorCodes){
		this.colorCodes = newColorCodes;
		this.setDigitsUsingColor(this.colorCodes);
	}
	
	public void setDigitsUsingResistance(double newResistance, double tolerance) {
		colorDigits[4] = tolerance;
		this.tolerance = colorDigits[4];
		if (newResistance > 100) {
			int count = 0;
			while (newResistance >= 1000) {
				newResistance = newResistance/10;
				count++;
			}
			
			colorDigits[3] = count;
			colorDigits[2] = newResistance%10;
			colorDigits[1] = (newResistance%100 - newResistance%10)/10;
			colorDigits[0] = (newResistance - newResistance%100)/100; 
			return;
		}
		else if (newResistance <= 100) {
			int count = 0;
			while (newResistance < 100) {
				newResistance = newResistance*10;
				count++;
			}
			
			colorDigits[3] = 0 - count;
			colorDigits[2] = newResistance%10;
			colorDigits[1] = ((newResistance - colorDigits[2])/10)%10; 
			colorDigits[0] = (newResistance - newResistance%100)/100;
			return;
		}
	}
	
	public void setColorUsingDigits(double resistance) {
		this.setDigitsUsingResistance(resistance, 0.20);
		for(int i = 0; i < colorDigits.length-1; i++) {
			colorCodes[i] = super.getResistanceColorFromDigit(colorDigits[i]);
		}
		
		colorCodes[4] = super.getToleranceColorFromDigit(colorDigits[4]);
	}
	
	public void setColorUsingDigits(double resistance, double tolerance) {
		this.setDigitsUsingResistance(resistance, tolerance);
		for(int i = 0; i < colorDigits.length-1; i++) {
			colorCodes[i] = super.getResistanceColorFromDigit(colorDigits[i]);
		}
		
		colorCodes[4] = super.getToleranceColorFromDigit(colorDigits[4]);
		
	}
	
	public void setDigitsUsingColor(String[] newColorCodes) {
		colorCodes = newColorCodes;
		for(int i = 0; i < colorCodes.length-1; i++) {
			colorDigits[i] = super.getResistanceDigitFromColor(colorCodes[i]);
		}
		
		colorDigits[4] = super.getToleranceDigitFromColor(colorCodes[4]);
		this.tolerance = colorDigits[4];
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
		
		return (colorDigits[0]*100 + colorDigits[1]*10 + colorDigits[2])*Math.pow(10, colorDigits[3]);
	}
	
	public double getTolerance() {
		if (this.tolerance != 0) {
			return this.tolerance;
		}
		
		return colorDigits[4];
	}
	
	public double getMaximumRange() {
		return this.getResistance() + this.getResistance()*this.tolerance;
	}
	
	public double getMinimumRange() {
		return this.getResistance() - this.getResistance()*this.tolerance;
	}
	
}
