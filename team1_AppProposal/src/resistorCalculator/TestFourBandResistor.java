package resistorCalculator;

public class TestFourBandResistor {

	public static void main(String[] args) {
		String[] Colors = {"Green", "Red", "Gold","Gold"};
		FourBandResistor Resistor = new FourBandResistor(Colors);
		Resistor.setDigitsUsingColor(Colors);
		System.out.println(Resistor.toString());
		
		System.out.println();
		
		FourBandResistor Resistor1 = new FourBandResistor(100);
		System.out.println(Resistor1.toString());
		
		System.out.println();
		
		FiveBandResistor Resistor2 = new FiveBandResistor(220);
		System.out.println(Resistor2.toString());
		
		System.out.println();
		
		String[] newColors = {"Brown", "Black", "Red" ,"Yellow", "Gold"};
		FiveBandResistor Resistor3 = new FiveBandResistor(newColors);
		System.out.println(Resistor3.toString());
	}
		
}
