import java.io.*;
import java.util.*;
public class IOanalytics_user
{
	public static void main ( String[ ] args ) 		
	{

		/* A) Use Microsoft Excel or a text editor to create a CSV file
		   B) Write a program to compute analytics on the CSV file above */
		
		// Read the CSV file above, save in a 2 dimensional array or arraylist
		String input_filename  = "../lecture11/data/dataset3.csv";            	//relative path 
		String[ ][ ] two_dim_array = null;		//2 dim array to hold all the data points

		try {
				FileReader file_reader = new FileReader(input_filename);		// read the file
				LineNumberReader line_num_reader 	= new LineNumberReader(file_reader);	 
				line_num_reader.skip(Long.MAX_VALUE);			
				int row_num = line_num_reader.getLineNumber( );	//obtain the num of lines 
				file_reader.close( );								//close the file

				two_dim_array = new String[row_num][ ];	//create a two-dimensional array

				FileReader file_reader2          = new FileReader(input_filename);	
				BufferedReader buffer_reader2 = new BufferedReader(file_reader2);	

				int row = 0;
				String line;
				System.out.println("SOURCE INPUT...");
				while ( (line = buffer_reader2.readLine( )) != null ) 		//while there are lines in the file
				{
					System.out.println(line);
					String[ ] csv_array	= line.split(",");	//split on commas
					two_dim_array[row]	= csv_array;		//append 1D array to the 2D array
					row++;						
				}
		} 
		catch (Exception e) {
				System.out.println(e);
		}

		System.out.println( );
		System.out.println( "COMPUTATION..." );
		// analytics by row
        for (int row = 0; row < two_dim_array.length; row++)	{
			List<Double> numbers = new ArrayList<>();
			for (String col : two_dim_array[row]) {
                System.out.printf("%7s ", col );		// print each row as string first
				try {
					numbers.add(Double.parseDouble(col));
				} catch (NumberFormatException e) {
					//System.out.print("Null");
					//Do nothing
				}
			}
			int count = numbers.size();
			Analytics analytics = new Analytics(numbers); //create an instance
			double sum = analytics.getSum();
			double mean = analytics.getMean();
			double median = analytics.getMedian();
			String mode = analytics.getMode(); //If all values occur only once, no mode. If multiple values occur most often, choose one. 
			double min = Collections.min(numbers);
			double max = Collections.max(numbers);
			double range = max - min;
			double stdDev = analytics.getStdDev();
			System.out.printf("| Count: %d, Sum: %.2f, Mean: %.2f, Median: %.2f, Mode: %5s, Min: %.2f, Max: %.2f, Range: %.2f, stdDev: %.2f", count,sum,mean,median,mode,min,max,range,stdDev);		//round to 2 decimal point
			System.out.println( );
		}

		// analytics by column
		System.out.println("Perform the same analytics as above for each column:");
		for (int col = 0; col < two_dim_array[0].length; col++)	{
			List<Double> numbers2 = new ArrayList<>();
			for (int row = 0; row < two_dim_array.length; row++) {
                String num = two_dim_array[row][col];
				try {
					numbers2.add(Double.parseDouble(num));
				} catch (NumberFormatException e) {
					//System.out.print("Null");
					//Do nothing
				}
			}
			int count2 = numbers2.size();
			Analytics analytics2 = new Analytics(numbers2); //create an instance
			double sum2 = analytics2.getSum();
			double mean2 = analytics2.getMean();
			double median2 = analytics2.getMedian();
			String mode2 = analytics2.getMode(); //If all values occur only once, no mode. If multiple values occur most often, choose one. 
			double min2 = Collections.min(numbers2);
			double max2 = Collections.max(numbers2);
			double range2 = max2 - min2;
			double stdDev2 = analytics2.getStdDev();
			System.out.printf("Column %d: Count: %d, Sum: %.2f, Mean: %.2f, Median: %.2f, Mode: %5s, Min: %.2f, Max: %.2f, Range: %.2f, stdDev: %.2f", col, count2,sum2,mean2,median2,mode2,min2,max2,range2,stdDev2);		//round to 2 decimal point
			System.out.println( );
		}

		//analytics for the entire dataset
		System.out.println("--------OVERALL-------------"); 
		List<Double> numbers3 = new ArrayList<>();
		for (int row = 0; row < two_dim_array.length; row++)	{
			for (String col : two_dim_array[row]) {
				try {
					numbers3.add(Double.parseDouble(col));
				} catch (NumberFormatException e) {
					//System.out.print("Null");
					//Do nothing
				}
			}
		}
		int count3 = numbers3.size();
		Analytics analytics3 = new Analytics(numbers3); //create an instance
		double sum3 = analytics3.getSum();
		double mean3 = analytics3.getMean();
		double median3 = analytics3.getMedian();
		String mode3 = analytics3.getMode(); //If all values occur only once, no mode. If multiple values occur most often, choose one. 
		double min3 = Collections.min(numbers3);
		double max3 = Collections.max(numbers3);
		double range3 = max3 - min3;
		double stdDev3 = analytics3.getStdDev();
		System.out.printf("Entire dataset: Count: %d, Sum: %.2f, Mean: %.2f, Median: %.2f, Mode: %5s, Min: %.2f, Max: %.2f, Range: %.2f, stdDev: %.2f",count3,sum3,mean3,median3,mode3,min3,max3,range3,stdDev3);		//round to 2 decimal point
		System.out.println( );

		//re-print all analytics for column 1 again
		System.out.println("--------COLUMN 1 AGAIN-------------"); 
		List<Double> numbers4 = new ArrayList<>();
		for (int row = 0; row < two_dim_array.length; row++) {
			String num = two_dim_array[row][0];
			try {
				numbers4.add(Double.parseDouble(num));
			} catch (NumberFormatException e) {
				//System.out.print("Null");
				//Do nothing
			}
		}
		int count4 = numbers4.size();
		Analytics analytics4 = new Analytics(numbers4); //create an instance
		double sum4 = analytics4.getSum();
		double mean4 = analytics4.getMean();
		double median4 = analytics4.getMedian();
		String mode4 = analytics4.getMode(); //If all values occur only once, no mode. If multiple values occur most often, choose one. 
		double min4 = Collections.min(numbers4);
		double max4 = Collections.max(numbers4);
		double range4 = max4 - min4;
		double stdDev4 = analytics4.getStdDev();
		System.out.printf("Column %d: Count: %d, Sum: %.2f, Mean: %.2f, Median: %.2f, Mode: %5s, Min: %.2f, Max: %.2f, Range: %.2f, stdDev: %.2f", 0, count4,sum4,mean4,median4,mode4,min4,max4,range4,stdDev4);		//round to 2 decimal point
		System.out.println( );

		System.out.printf("Column %d: ", 0);	
		String result = analytics4.getAllStats();
		System.out.println(result);
		
		//transpose the 2 dimensional array (rows become columns, and columns become rows)


		//recompute all analytics steps 1-4 for the transposed array, and print
	}
}
