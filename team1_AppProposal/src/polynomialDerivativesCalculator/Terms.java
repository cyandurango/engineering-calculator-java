package polynomialDerivativesCalculator;

/* =============================================================================================
 * CLASS NAME		:	Terms
 * DESCRIPTION		:	A class that contains all attributes and functions of a Term
 * AUTHOR			:	Cyril Andre B. Durango 
 * COPYRIGHT		:	created September 26, 2023
 * ------------------------------------------------------------------------------------------
 * REVISION HISTORY		
 * Date:				| By:							| Description:
 * ---------------------|-------------------------------|------------------------------------
 * November 27, 2023	| Cyril Andre B. Durango		| Added documentation for the
 * 						|								| class and each of the methods	
 * =============================================================================================
 */
class Terms {
	private static int i;
	private char[] originalTerm;
	
	// ----------------------------- CONSTRUCTORS PLACE UNDER HERE ----------------------------- //
	/* ==================================================================
	 * METHOD NAME		:	Terms
	 * DESCRIPTION		:	A Constructor to call a default "Terms"
	 * 						object
	 * PRE-CONDITION	:	N/A
	 * POST-CONDITION	:	N/A
	 * ==================================================================
	 */
	Terms(){
	}
	
	/* ==================================================================
	 * METHOD NAME		:	Terms
	 * DESCRIPTION		:	A Constructor that instantiates a "Terms"
	 * 						object  
	 * PRE-CONDITION	:	An algebraic term is inputed in form of a 
	 * 						String 
	 * POST-CONDITION	:	Converts the string into a character array
	 * ==================================================================
	 */
	Terms(String term){
		this.setOriginalTerm(term);
	}
	
	// ------------------------------- SETTERS PLACE UNDER HERE -------------------------------- //
	/* ==================================================================
	 * METHOD NAME		:	setOriginalTerm
	 * DESCRIPTION		:	A Setter that sets the original term into
	 * 						the "Terms" object
	 * PRE-CONDITION	:	An algebraic term is inputed in form of a 
	 * 						String 
	 * POST-CONDITION	:	Converts the string into a character array
	 * ==================================================================
	 */
	public void setOriginalTerm(String term) {
		this.originalTerm = new char[term.length()];
		for (int i = 0; i < term.length(); i++) {
			this.originalTerm[i] = term.charAt(i);
		}
	}
	
	// ------------------------------- GETTERS PLACE UNDER HERE -------------------------------- //
	/* ==================================================================
	 * METHOD NAME		:	getOriginalTerm
	 * DESCRIPTION		:	A getter that gets the original term from
	 * 						the "Terms" object
	 * PRE-CONDITION	:	N/A
	 * POST-CONDITION	:	returns the originalTerm character array 
	 * 						as a string
	 * ==================================================================
	 */
	public String getOriginalTerm() {
		String originalTerm = "";
		for (int i = 0; i < this.originalTerm.length; i++) {
			originalTerm = originalTerm + this.originalTerm[i];
		}
		return originalTerm;
	}
	
	// ------------------------------------- OTHER METHODS ------------------------------------- //
	/* ==================================================================
	 * METHOD NAME		:	getCoefficient
	 * DESCRIPTION		:	identifies the coefficient of the term
	 * PRE-CONDITION	:	Stores the numbers before the variable 'x'
	 * POST-CONDITION	:	returns the coefficient as an integer
	 * ==================================================================
	 */
	private int getCoefficient() {
		int coefficient = 0;
		String coeffString = "";
		
		if (this.originalTerm[0] == 'x') {
			return 1;
			
		}
		
		if (this.originalTerm[0] == '-' && this.originalTerm[1] == 'x') {
			i++;
			return -1;
		}
		
		if (this.originalTerm[0] == '+' && this.originalTerm[1] == 'x') {
			i++;
			return 1;
		}
		
		try {
			while (this.originalTerm[i] != 'x') {
				coeffString = coeffString + originalTerm[i];
				i++;
				
			}
			
			coefficient = Integer.parseInt(coeffString);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			coefficient = Integer.parseInt(coeffString);
		}
		
		return coefficient;
	}
	
	/* ==================================================================
	 * METHOD NAME		:	getPower
	 * DESCRIPTION		:	identifies the power of the term
	 * PRE-CONDITION	:	Stores the numbers after the '^' character
	 * POST-CONDITION	:	returns the power as an integer
	 * ==================================================================
	 */
	private int getPower() {
		int power = 0;
		String powerString = "";
		
		if (i < this.originalTerm.length) {
			try {
				if (originalTerm[i] == 'x') {
					power = 1;
				}
			} 
			catch (ArrayIndexOutOfBoundsException e) {
				power = 0;
			}
		}
			
		if (i+2 < this.originalTerm.length){
			for (i = i+2 ; i < originalTerm.length ; i++) {
				powerString = powerString + originalTerm[i];
			}
			power = Integer.parseInt(powerString);
		}
		
		return power;
	}
	
	/* ==================================================================
	 * METHOD NAME		:	derivedTerm
	 * DESCRIPTION		:	calculates the derived form of the term
	 * PRE-CONDITION	:	the coefficient and power is used to find
	 * 						the derived term
	 * POST-CONDITION	:	returns the derived form of the original
	 * 						term as a string
	 * ==================================================================
	 */
	public String derivedTerm() {
		
		i = 0;
		int coefficient = this.getCoefficient();
		int power = this.getPower();
		int derivedCoefficient = coefficient * power;
		int derivedPower = power - 1;
		
		
		if (derivedPower == 1 && coefficient > 0) {
			return "+" + derivedCoefficient + "x";
		}
		
		if (derivedPower == 1 && coefficient < 0) {
			return "" + derivedCoefficient + "x";
		}
		
		if (derivedPower > 1 && coefficient > 0) {
			return "+" + derivedCoefficient + "x^" + derivedPower;
		}
		
		if (derivedPower > 1 && coefficient < 0) {
			return derivedCoefficient + "x^" + derivedPower;
		}
		
		if (derivedPower < -1 && coefficient > 0) {
			return derivedCoefficient + "x^" + derivedPower;
		}
		
		if (derivedPower < -1 && coefficient < 0) {
			return "+" + derivedCoefficient + "x^" + derivedPower;
		}
		
		if (derivedPower == 0 && coefficient <= -1) {
			return "" + derivedCoefficient;
		}
		
		if (derivedPower == 0 && coefficient >= 1) {
			return "+" + derivedCoefficient;
		}
		
		
		
		return "+0";
	
	}
	
}
