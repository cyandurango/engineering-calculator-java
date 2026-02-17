package engineeringEconomicsCalculator;

public class Annuity extends CompoundInterest{
	private double annuity = 0;

	public Annuity() {
		super();
	}

	public Annuity(double interestRate, double period, double presentValue, double futureValue, double annuity) {
		super(interestRate, period, presentValue, futureValue);
		this.annuity = annuity;
	}

	public void setAnnuity(double annuity) {
		this.annuity = annuity;
	}
	
	public double getAnnuity() {
		if (this.annuity == 0 && this.futureValue != 0) {
			this.annuity = this.annuityGivenFuture();
		} 
		
		else if (this.annuity == 0 && this.presentValue != 0) {
			this.annuity = this.annuityGivenPresent();
		}
		
		return this.annuity;
	}
	
	@Override
	public double getPresentValue() {
		if (this.presentValue == 0 && this.futureValue != 0) {
			this.presentValue = super.getPresentValue();
		}
		
		if (this.presentValue == 0 && this.annuity != 0) {
			this.presentValue = this.presentGivenAnnutiy();
		}
		
		return this.presentValue;
	}
	
	@Override
	public double getFutureValue() {
		if (this.futureValue == 0 && this.presentValue != 0) {
			this.futureValue = super.getFutureValue();
		}
		if (this.futureValue == 0 && this.annuity != 0) {
			this.futureValue = this.futureGivenAnnuity();
		}
			
		return this.futureValue;
	}
	
	private double futureGivenAnnuity() {
		return this.getAnnuity()*(((Math.pow(1 + (this.getInterestRate()), this.getPeriod())-1)/(this.getInterestRate())));
	}
	
	private double annuityGivenFuture() {
		return this.getFutureValue()/(((Math.pow(1 + (this.getInterestRate()), this.getPeriod())-1)/(this.getInterestRate())));
	}
	
	private double presentGivenAnnutiy() {
		return this.getAnnuity()*(((Math.pow(1 + (this.getInterestRate()), this.getPeriod())-1)/((this.getInterestRate())*Math.pow(1 + (this.getInterestRate()), this.getPeriod()))));
	}
	
	private double annuityGivenPresent() {
		return this.getPresentValue()*(((this.getInterestRate())*(Math.pow(1 + this.getInterestRate(), this.getPeriod())))/((Math.pow(1 + this.getInterestRate(), this.getPeriod()))-1));
	}
}
