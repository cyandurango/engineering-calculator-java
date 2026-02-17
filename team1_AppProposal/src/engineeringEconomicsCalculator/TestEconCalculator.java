package engineeringEconomicsCalculator;

public class TestEconCalculator {
	public static void main (String[] args) {
		System.out.print("=============SIMPLE & COMPOUND INTEREST=============");
		SimpleInterest problem1 = new SimpleInterest(0.10,4,1000, 0);
		CompoundInterest problem2 = new CompoundInterest(0.10,5,500, 0);
		System.out.printf("\nFuture Worth: %.2f", problem1.getFutureValue());
		System.out.printf("\nFuture Worth: %.2f", problem2.getFutureValue());
		
		problem1.setPresentValue(0);
		System.out.printf("\nPresent Worth: %.2f", problem1.getPresentValue());
		
		problem2.setPresentValue(0);
		System.out.printf("\nPresent Worth: %.2f", problem2.getPresentValue());
		
		SimpleInterest problem4 = new SimpleInterest(0.10, 0,1000, 5000);
		CompoundInterest problem5 = new CompoundInterest(0.10, 0, 1000, 5000);
		System.out.printf("\nPeriod: %.2f", problem4.getPeriod());
		System.out.printf("\nPeriod: %.2f", problem5.getPeriod());
		
		problem4.setInterestRate(0);
		problem5.setInterestRate(0);
		
		System.out.printf("\nInterest Rate: %.2f", problem4.getInterestRate());
		System.out.printf("\nInterest Rate: %.2f", problem5.getInterestRate());
		
		System.out.print("\n\n============= ANNUITY =============");
		Annuity problem3 = new Annuity(0.20,5,0,0,1000);
		System.out.printf("\nPresent Worth: %.2f", problem3.getPresentValue());
		System.out.printf("\nFuture Worth: %.2f", problem3.getFutureValue());
		
		System.out.printf("\nAnnuity: %.2f", problem3.getAnnuity());
	}
}
