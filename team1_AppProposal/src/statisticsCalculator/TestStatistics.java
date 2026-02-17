package statisticsCalculator;

public class TestStatistics {

	public static void main(String[] args) {
		double[] data = {1,2,3,4,5,5,5,6,7,8,9};
		
		StatisticsOperations population = new Population(data);
		StatisticsOperations sample = new Sample(data);
		
		System.out.println(population.toString());
		System.out.println(sample.toString());
	}

}
