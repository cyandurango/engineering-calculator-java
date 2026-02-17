package statisticsCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public abstract class StatisticsOperations {
	ArrayList<Double> dataSets = new ArrayList<>();
	
	public StatisticsOperations() {
	}
	
	public StatisticsOperations(ArrayList<Double> dataSets) {
		this.dataSets = dataSets;
	}
	
	public StatisticsOperations(double[] dataArray) {
		for (int i = 0; i < dataArray.length; i++) {
			this.dataSets.add(dataArray[i]);
		}
	}
	
	public StatisticsOperations(double datum) {
		this.dataSets.add(datum);
	}
	
	public void setDatum(double datum) {
		this.dataSets.add(datum);
	}
	
	public double getMinimum() {
		double minimum = dataSets.get(0);
		for (int i = 1; i < dataSets.size(); i++) {
			if (dataSets.get(i) < minimum) {
				minimum = dataSets.get(i);
			}
		}
		return minimum;
	}
	
	public double getMaximum() {
		double maximum = dataSets.get(0);
		for (int i = 1; i < dataSets.size(); i++) {
			if (dataSets.get(i) > maximum) {
				maximum = dataSets.get(i);
			}
		}
		return maximum;
	}
	
	public double getRange() {
		return this.getMaximum() - this.getMinimum();
	}
	
	public double getMean() {
		double sum = 0;
		for (int i = 0; i < dataSets.size(); i++) {
			sum = sum + dataSets.get(i);
		}
		
		return sum/dataSets.size();
	}
	
	private void sortDataSet(){
        dataSets.sort(StatisticsOperations.sortAscending);
    }
    private static Comparator<Double> sortAscending = (Double o1, Double o2) -> (int) (o1 - o2);
	
	public double getMedian() {
		sortDataSet();
		double median = 0;
        if(this.dataSets.size() % 2 == 0){
            median += dataSets.get(this.dataSets.size() / 2 -1);
            median += dataSets.get(this.dataSets.size() / 2);
            median /= 2;
        }else
            median = dataSets.get(this.dataSets.size() / 2);
        return median;
	}
	
    public ArrayList<Double> getMode(){
    	Map<Double, Integer> frequencyMap = new HashMap<>();
        for(double numbers: dataSets)
            frequencyMap.put(numbers, frequencyMap.getOrDefault(numbers, 0) + 1);
        int maximumFrequency = 0;
        for(int frequency: frequencyMap.values())
            if(frequency > maximumFrequency)
                maximumFrequency = frequency;
        ArrayList<Double> modes = new ArrayList<>();
        for(Map.Entry<Double, Integer> entry: frequencyMap.entrySet())
            if(entry.getValue() == maximumFrequency)
                modes.add(entry.getKey());
        return modes;
    }
    
    public String formatList(ArrayList<Double> mode){
        StringBuilder outMode = new StringBuilder();
        boolean isFirst = true;
        for(Double numbers: mode){
            if(isFirst){
                outMode.append(numbers);
                isFirst = false;
            }else outMode.append(", ").append(numbers);
        }
        return String.valueOf(outMode);
    }
    
    public abstract double getStandardDeviation();
    public abstract double getVariance();
    
    @Override
    public String toString() {
        String mode = formatList(getMode());
        return String.format(
                "\nStatistics Population\n" +
                        "Minimum: %.2f\n" +
                        "Maximum: %.2f\n" +
                        "Range: %.2f\n" +
                        "Mean: %.2f\n" +
                        "Median: %.2f\n" +
                        "Mode: " + mode +"\n" +
                        "Standard Deviation: %.2f\n" +
                        "Variance: %.2f", getMinimum(), getMaximum(),getRange(), getMean(),
                getMedian(), getStandardDeviation(), getVariance());
    }
}
