package polynomialDerivativesCalculator;

import java.util.Scanner;

public class TestDerivatives {

	public static void main(String[] args) {
		
		System.out.println("Enter polynomial: ");
		Scanner scan = new Scanner(System.in);
		String string = scan.next();
		
		Polynomial terms = new Polynomial();
		terms.setOrigPolynomialEquation(string);
		System.out.println(terms.getPolynomialEquationFromArray());
		System.out.println("Derived Equation: " + terms.calculateDerivedEquation());
		scan.close();
		
		
	}

}
