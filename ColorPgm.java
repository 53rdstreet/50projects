public class ColorPgm 
{
	public static void main ( String[ ] args ) 		//or  (String[ ] arguments), or any name
	{
		if ( args.length  < 4)  				//number of arguments supplied
		{
		      System.out.println("Re-execute with at least 4 arguments");
		      System.exit(-1);							//end the program
		}

		String color1 =  args[0];			//obtain the value of first argument
		String color2 =  args[1];
		int  num1 =  Integer.parseInt( args[2] );	//convert the string argument to a number
		double n2 = Double.parseDouble( args[3] );

// how about…

		for (int i = 0;  i < args.length;  i++)				//loop from 0 to array length
		      System.out.println( i + " arguments is " + args[i] );
	}
}
