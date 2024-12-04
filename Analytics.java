import java.util.*;
public class Analytics
{        
    private List<Double> numbers; // Instance variables 
    
	// Constructor to initialize the class with numbers list array
	public Analytics(List<Double> numbers) {
		this.numbers = numbers;
	}

	public double getMedian() {
        Collections.sort(numbers);	//sort() for ArrayList
        int size = numbers.size();	//get array length
        if (size % 2 == 0) {		//If array has even number of elements, 
            return (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2.0; //take average of 2 mid-points
        } 
		else {
            return numbers.get(size / 2);
        }
	}

	public double getSum() {
        double sum = 0;
        for (double num: numbers) {
            sum = sum+num;
        }
		return sum;
    }

	public double getMean() {
        double sum = this.getSum(); //call getSum() method within the same class instance
		double mean = sum / numbers.size();
		return mean;
    }

	public String getMode() {
        Collections.sort(numbers);	//sort() for Array
        int size = numbers.size();	//get array length

		double mode = numbers.get(0); // initialize the mode value
        int max_count = 1;
        int current_count = 1;

		for (int i = 1; i < size; i++) {
            if (Double.compare(numbers.get(i), numbers.get(i - 1)) == 0) { //if the current number is the same as the previous one
                current_count++;
            } else {
                //if the current number is different, check the frequency of the previous number
                if (current_count > max_count) {
                    max_count = current_count;
                    mode = numbers.get(i - 1);
                }
                current_count = 1; // Reset count for the new number
            }
        }
		if (current_count > max_count) {
			mode = numbers.get(size - 1);  //set mode to the last number if it has the highest frequency
		}
		if (max_count == 1) {
            return null;	//if all values occur only once, return null
        }
        return Double.toString(mode);        
	}

	public double getStdDev() {
        double mean = this.getMean(); //call getMean() method within the same class instance
        double sum_squares = 0.0; //initiate sum of squares
        for (double num: numbers) {
            sum_squares += Math.pow(num - mean, 2);
        }
        double stdDev = Math.sqrt(sum_squares / numbers.size()); //get square root of sum of squares
		return stdDev;
    }

    public String getAllStats() {
        int count = numbers.size();
		double sum = this.getSum(); //call getSum() method within the same class instance
		double mean = this.getMean();
		double median = this.getMedian();
		String mode = this.getMode();
		double min = Collections.min(numbers);
		double max = Collections.max(numbers);
		double range = max - min;
		double stdDev = this.getStdDev();

		return String.format("Count: %d, Sum: %.2f, Mean: %.2f, Median: %.2f, Mode: %5s, Min: %.2f, Max: %.2f, Range: %.2f, stdDev: %.2f", count,sum,mean,median,mode,min,max,range,stdDev);
    }

}
