package engineeringEconomicsCalculator;

public abstract class Interest {
	protected double interestRate = 0;
	protected double period = 0;
	
	public Interest() {
	}

	public Interest(double interestRate, double period) {
		this.interestRate = interestRate;
		this.period = period;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void setPeriod(double period) {
		this.period = period;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public double getPeriod() {
		return period;
	}

	public abstract double getPresentValue();
	public abstract double getFutureValue();
	
	
	
}
