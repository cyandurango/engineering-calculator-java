package statisticsCalculator;

import java.util.ArrayList;

public class Population extends StatisticsOperations {

	
	public Population() {
		super();
	}

	public Population(ArrayList<Double> dataSets) {
		super(dataSets);
	}

	public Population(double datum) {
		super(datum);
	}

	public Population(double[] dataArray) {
		super(dataArray);
	}

	public double getVariance() {
        double sum = 0;
        for(Double numbers: dataSets)
            sum += (numbers - getMean()) * (numbers - getMean());
        return sum / this.dataSets.size();
	}
	
	public double getStandardDeviation() {
		return Math.sqrt(this.getVariance());
	}

	
}
