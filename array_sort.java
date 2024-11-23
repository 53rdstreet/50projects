import java.util.Arrays;
public class array_sort
{
	public static void main ( String[ ] args ) 		
	{

		/* Enter numerous words as command line arguments
		Example: java sortpgm apples oranges pears bananas strawberries apricots */
		
		// Check to make sure that the client entered at least 3 or more words, if not, print message and exit
		if ( args.length  < 3)  				//number of arguments provided by user
		{
		      System.out.println("Re-execute with at least 3 words");
		      System.exit(-1);							//exit the program
		}
		
		// Print all entered words each on a separate line
		for (int i = 0;  i < args.length;  i++)				//loop from 0 to array length
		      System.out.println( "Number " + i + " argument is " + args[i] );

		// Concatenate all those words into a single string with only a space between the words
		// Print the string
		String concat = String.join(" ", args);	
		System.out.println(concat); 

		// Create a sort method to sort the words array in ascending alphabetical order. Try coming up with your own sort algorithm.
		// Document your code by adding a comment to each line of the sort algorithm code.
		String[] sorted_words = merge_sort_words(args);

		// After the sort, take each word from the sorted array, copy it to a StringBuilder or StringBuffer, and print that StringBuilder/StringBuffer on a separate line
		StringBuilder sorted_words_StringBuilder = new StringBuilder();
		for (String word : sorted_words) {
			StringBuilder word_StringBuilder = new StringBuilder(word);
			System.out.println(word_StringBuilder.toString()); 
			// Concatenate all those StringBuilder/StringBuffer words into a single StringBuilder/StringBuffer with a space between the words
            sorted_words_StringBuilder.append(word).append(" ");
        }

		// Print the StringBuilder/StringBuffer
		System.out.println(sorted_words_StringBuilder.toString()); 

	}

	public static String[] merge_sort_words(String[] words) {
		/* it's a divide and concur merge sort that utilizes recusion: 
		keep splitting the array into half of it's original size and sort each half, then merge the sorted halves together */
		
		// recursion stop test: if the array is already <= 1 word long, return it as the sorted result
		if (words.length <= 1){
			return words;
		}

		// get the index of the mid point of the array with floor division 
		int m = words.length / 2;
		// create string array "left" to contain the left half of the array (index 0 to m-1), pass it into the current function recursively to split it again
		String [] left = merge_sort_words(Arrays.copyOfRange(words, 0, m)); 
		// create string array "right" to contain the right half of the array(index m to length-1), pass it into the current function recursively to split it again
		String [] right = merge_sort_words(Arrays.copyOfRange(words, m, words.length)); 

		// call the merge_arrays function to merge two halves back together while keeping the ascending alphabetical order.
		// in actual execution, this function will start with merging the smallest unites, 
		// which are two arrays of length 1 and 1. this step makes sure each half are already sorted before they're merged.
		return merge_arrays(left, right);

	}

	public static String[] merge_arrays(String[] left, String[] right) {
		// merge the sorted halves back together while keeping the ascending alphabetical order
		
		// make new string array "result" that has the length of "left" and "right" combined, so it can contain the sorted result
		String[] result = new String[left.length+right.length];
		// set 3 counters a, b and c to 0
		int a = 0;
		int b = 0;
		int c = 0;

		while (a < left.length & b < right.length) // looping over the words in each side of the two arrays, loop while index is within length
		{
			if (left[a].compareToIgnoreCase(right[b]) < 0){ // use String method compareToIgnoreCase to compare the words from each half alphabetically
				result[c] = left[a]; // put the "smaller" word into the bucket first - left half has the smaller word in this case
				c++; // add to the result bucket counter
				a++; // add to the left bucket counter
			}
			else{
				result[c] = right[b]; // put the "smaller" word into the bucket first - now right half has the smaller word
				c++; // add to the result bucket counter
				b++; // add to the right bucket counter
			}
		}
		// if any, copy the remaining words in the left array to result array
		while (a < left.length) { // loop while index is within left array length
			result[c] = left[a];
			c++;
			a++;
		}
	
		// if any, copy the remaining words in the right array to result array 
		while (b < right.length) { // loop while index is within right array length
			result[c] = right[b];
			c++;
			b++;
		}

		return result; // return the sorted and merged array
	}

}
