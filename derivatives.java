import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		new Main();
	}
	
	public String differentiateTerm(int coefficient, int power, boolean isPositive) {
		return (((isPositive && power > 0) ? ("+") : (power < 0 && !isPositive) ? ("+") : ("-")) + 
			((coefficient * power < 0) ? (coefficient * power * - 1) : (coefficient * power)) +
			((power-1 == 0) ? ("  ") : (power-1 == 1) ? ("x ") : ("x^" + (power-1) + " ")));
	}
	
	/* Example:
	 
	 Input: y= x^5 + x^3 -2x
	 Output: y' = 5x^4 + 3x^2 - 2x^0 
	 
	 */
	public Main() throws IOException {
		BufferedReader in;
		in = new BufferedReader (new InputStreamReader (System.in));//Used for CCC
		StringTokenizer st = new StringTokenizer(in.readLine());
		boolean firstToken = true;
		String output = "y'= ";
		//System.out.println((char)'0' + " " + '9');
		while(st.hasMoreTokens()) {
			boolean isPositive;
			int power;
			int coefficient;
			String input = st.nextToken();
			int endOfCoefficient = 0;
			if(firstToken) {
				if(input.charAt(0) == '-') {
					isPositive = false;
				}
				else {
					isPositive = true;
				}
				
			} else {
				if(input.charAt(0) == '+')
					isPositive = true;
				else
					isPositive = false;
			}
			
			for(int i = ((isPositive && firstToken) ? (0) : (1)); i < input.length(); i++) {
				//System.out.println(input.charAt(i));
				if(input.charAt(i) > '9' || input.charAt(i) < '0') {
					endOfCoefficient = i-1;
					break;
				}
			}
			if(endOfCoefficient != -1) {
				//System.out.println(endOfCoefficient);
				coefficient = Integer.parseInt(input.substring(((isPositive && firstToken) ? (0) : (1)), endOfCoefficient+1));
				power = Integer.parseInt(input.substring(endOfCoefficient + 3));// plus two?
			} 
			else { 
				coefficient = 1;
				power = Integer.parseInt(input.substring(endOfCoefficient + 3));// plus two?
			}
			//System.out.println(coefficient + "x^" + power);
			if(firstToken)
				firstToken = false;
			output += differentiateTerm(coefficient, power, isPositive);
		}
		System.out.println(output);
	}
	
}