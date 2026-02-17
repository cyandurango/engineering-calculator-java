package statisticsCalculator;

import java.util.ArrayList;

public class Sample extends StatisticsOperations{

	public Sample() {
		super();
	}

	public Sample(ArrayList<Double> dataSets) {
		super(dataSets);
	}

	public Sample(double datum) {
		super(datum);
	}

	public Sample(double[] dataArray) {
		super(dataArray);
	}
	
	public double getVariance() {
        double sum = 0;
        for(Double numbers: dataSets)
            sum += (numbers - getMean()) * (numbers - getMean());
        return sum / (this.dataSets.size() - 1);
	}
	
	public double getStandardDeviation() {
		return Math.sqrt(this.getVariance());
	}
}
