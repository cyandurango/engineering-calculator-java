package polynomialDerivativesCalculator;

import java.util.ArrayList;

/* =============================================================================================
 * CLASS NAME		:	Polynomial
 * DESCRIPTION		:	A class that contains all attributes and functions of a Polynomial
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
public class Polynomial {
	private ArrayList<Terms> origPolynomialEqArray;
	private String origPolynomialEq;
	
	// ----------------------------- CONSTRUCTORS PLACE UNDER HERE ----------------------------- //
	/* ==================================================================
	 * METHOD NAME		:	Polynomial
	 * DESCRIPTION		:	A Constructor to call a default "Polynomial"
	 * 						object
	 * PRE-CONDITION	:	N/A
	 * POST-CONDITION	:	N/A
	 * ==================================================================
	 */
	public Polynomial (){	
		origPolynomialEqArray = new ArrayList<Terms>();
		origPolynomialEq = "";
	}
	
	/* ==================================================================
	 * METHOD NAME		:	Polynomial
	 * DESCRIPTION		:	A Constructor that instantiates a 
	 * 						"Polynomial" object  
	 * PRE-CONDITION	:	the polynomial is stored inside the object
	 * POST-CONDITION	:	Converts the polynomial into a string array
	 * 						separating the polynomial into terms
	 * ==================================================================
	 */
	public Polynomial (String origPolynomialEq){
		this.origPolynomialEq = origPolynomialEq;
		this.setPolynomialEquationIntoArray();
	}
	
	// ------------------------------- SETTERS PLACE UNDER HERE -------------------------------- //
	/* ==================================================================
	 * METHOD NAME		:	setOrigPolynomialEquation
	 * DESCRIPTION		:	sets the polynomial equation inside the
	 * 						'Polynomial' object
	 * PRE-CONDITION	:	the polynomial is stored inside the object
	 * POST-CONDITION	:	Converts the polynomial into a string array
	 * 						separating the polynomial into terms
	 * ==================================================================
	 */
	public void setOrigPolynomialEquation (String origPolynomialEq) {
		this.origPolynomialEq = origPolynomialEq;
		this.setPolynomialEquationIntoArray();
	}
	
	/* ==================================================================
	 * METHOD NAME		:	setPolynomialEquationIntoArray
	 * DESCRIPTION		:	converts the stringed equation into an 
	 * 						array of Terms 
	 * PRE-CONDITION	:	The polynomial is in a form of a string
	 * POST-CONDITION	:	The string is broken apart into "Terms"
	 * 						objects and stored into an array
	 * ==================================================================
	 */
	private void setPolynomialEquationIntoArray() {
		String newTerm = "";
		for (int i = 0; i < this.getOrigPolynomialEquation().length(); i++) {
			if (i!=0 && (this.getOrigPolynomialEquation().charAt(i) == '-' || this.getOrigPolynomialEquation().charAt(i) == '+') && this.getOrigPolynomialEquation().charAt(i-1) != '^' ){
				this.origPolynomialEqArray.add(new Terms(newTerm));
				newTerm = "" + this.getOrigPolynomialEquation().charAt(i);
			}
			else{
				newTerm = newTerm + this.getOrigPolynomialEquation().charAt(i);
			}
		} 
		this.origPolynomialEqArray.add(new Terms(newTerm));
	}
	
	// ------------------------------- GETTERS PLACE UNDER HERE -------------------------------- //
	/* ==================================================================
	 * METHOD NAME		:	getOrigPolynomialEquation
	 * DESCRIPTION		:	returns the polynomial equation
	 * PRE-CONDITION	:	N/A
	 * POST-CONDITION	:	returns the stored polynomial equation
	 * ==================================================================
	 */
	public String getOrigPolynomialEquation() {
		return this.origPolynomialEq;
	}
	
	/* ==================================================================
	 * METHOD NAME		:	getPolynomialEquationFromArray
	 * DESCRIPTION		:	displays the polynomial equation term by
	 * 						term with its corresponding index
	 * PRE-CONDITION	:	an array of terms was used
	 * POST-CONDITION	:	each term is displayed with its 
	 * 						corresponding index as to where it is
	 * 						stored in the array
	 * ==================================================================
	 */
	public String getPolynomialEquationFromArray () {
		String displayArray = "";
		for (int i = 0; i < this.origPolynomialEqArray.size(); i++) {
			displayArray = displayArray + "At Index [" + i + "]: " + this.origPolynomialEqArray.get(i).getOriginalTerm() + "\n";
		}
		
		return displayArray;
	}
	
	// ------------------------------------- OTHER METHODS ------------------------------------- //
	/* ==================================================================
	 * METHOD NAME		:	calculateDerivedEquation
	 * DESCRIPTION		:	the original equation is derived
	 * PRE-CONDITION	:	a "Terms" array was used.
	 * POST-CONDITION	:	each of the terms were derived and appended,
	 * 						then finally stringed together to get the
	 * 						derivation of the original equation
	 * ==================================================================
	 */
	public String calculateDerivedEquation() {
		StringBuilder derivedEquation = new StringBuilder();
		for (int i = 0; i < this.origPolynomialEqArray.size() ; i++) {
			derivedEquation.append(this.origPolynomialEqArray.get(i).derivedTerm());
		}
		
		if (derivedEquation.charAt(0) == '+') {
			derivedEquation = derivedEquation.deleteCharAt(0);
		}
		
		if (derivedEquation.charAt(derivedEquation.length()-1) == '0' && derivedEquation.length() > 1) {
			derivedEquation = derivedEquation.deleteCharAt(derivedEquation.length()-1);
			derivedEquation = derivedEquation.deleteCharAt(derivedEquation.length()-1);
		}
		
		return derivedEquation.toString();
	}
}
