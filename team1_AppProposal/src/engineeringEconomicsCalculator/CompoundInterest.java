package engineeringEconomicsCalculator;

public class CompoundInterest extends Interest{
	protected double presentValue = 0;
	protected double futureValue = 0;
	
	public CompoundInterest() {
		super();
	}

	public CompoundInterest(double interestRate, double period, double presentValue, double futureValue) {
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
	
	double calculatePresentValue() {
		return this.getFutureValue()*Math.pow(1.0 + super.getInterestRate(),-super.getPeriod());
	}
	
	double calculateFutureValue() {
		return this.getPresentValue()* Math.pow(1.0 + super.getInterestRate(),super.getPeriod());
	}
	
	@Override
	public double getInterestRate() {
		if (this.interestRate == 0) {
			this.interestRate = Math.pow((this.getFutureValue()/this.getPresentValue()), 1.0/super.getPeriod()) - 1;
		}
		return this.interestRate;
	}
	
	@Override
	public double getPeriod() {
		if (this.period == 0) {
			this.period = Math.log((this.getFutureValue()/this.getPresentValue()))/Math.log(1.0 + this.getInterestRate());
		}
		return this.period;
	}
}
