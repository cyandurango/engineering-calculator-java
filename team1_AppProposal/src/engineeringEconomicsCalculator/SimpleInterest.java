package engineeringEconomicsCalculator;

public class SimpleInterest extends Interest{
	private double presentValue = 0;
	private double futureValue = 0;
	
	public SimpleInterest() {
		super();
	}

	public SimpleInterest(double interestRate, double period, double presentValue, double futureValue) {
		super(interestRate, period);
		this.presentValue = presentValue;
		this.futureValue = futureValue;
		this.interestRate = this.getInterestRate();
		this.period = this.getPeriod();
	}
	
	public void setPresentValue(double presentValue) {
		this.presentValue = presentValue;
	}

	public void setFutureValue(double futureValue) {
		this.futureValue = futureValue;
	}

	public double getPresentValue() {
		if (this.presentValue == 0) {
			this.presentValue = this.calculatePresentValue();
		}
		
		return this.presentValue;
	}

	public double getFutureValue() {
		if (this.futureValue == 0) {
			this.futureValue = this.calculateFutureValue();
		}
		
		return this.futureValue;
	}
	
	private double calculatePresentValue() {
		return this.getFutureValue()/(1.00 + super.getInterestRate() * super.getPeriod());
	}
	
	private double calculateFutureValue() {
		return this.getPresentValue()*(1.00 + super.getInterestRate() * super.getPeriod());
	}
	
	@Override
	public double getInterestRate() {
		if (this.interestRate == 0) {
			this.interestRate = ((this.getFutureValue()/this.getPresentValue())-1.00)/super.getPeriod();
		}
		
		return this.interestRate;
	}
	
	@Override
	public double getPeriod() {
		if (this.period == 0){
			this.period = ((this.getFutureValue()/this.getPresentValue())-1.00)/super.getInterestRate();
		}
		return this.period;
	}
}
