import java.util.Stack;

public class Lab1 {
	/*
	 * @author Brett Koenig
	 * @date 2/11/13
	 * Sort an input of integers, in ascending order, using three stacks
	 * @param inputTrack Stack of input values to sort
	 * @return Stack of values from input in sorted order
	 */
	/*
	 * This function takes in the input and determines if it is null, and sorts the input if it is not null
	 */
	public static Stack<Integer> trainSort(Stack<Integer> inputTrack)
	{
		//initialize all needed variables
	  	int counter = 1;
	    int min, x;
		Stack<Integer> sideTrack = new Stack<Integer>();		
		Stack<Integer> exitTrack = new Stack<Integer>();
		//if input is null return an empty track
		if(inputTrack == null)			
		{			
			return exitTrack;			
		}
		//Sort the inputTrack to the exitTrack while the input is not empty
		while(!inputTrack.empty())			
		{	
			//find minimum value in input track
			min = findMin(inputTrack);			
			x = inputTrack.pop();
			//iterate through input track until min is found, while it is not found add values to sideTrack
			while(x!=min)				
			{				
				sideTrack.push(x);				
				System.out.println(counter + ".\tMove " + x + " from input to siding");				
				counter++;				
				x = inputTrack.pop();				
			}			
			exitTrack.push(x);			
			System.out.println(counter + ".\tMove " + x + " from input to exit");			
			counter++;
			//Clear the sideTrack so that the minimum in total input can be found again
			while(!sideTrack.empty())				
			{				
				x = sideTrack.pop();				
				System.out.println(counter + ".\tMove " + x + " from siding to input");			
				counter++;				
				inputTrack.push(x);				
			}			
		}		
		return exitTrack;		
	}
	/*
	 * This function looks at each value in the input stack, and returns the smallest value in the input
	 * This function will only be called if the parameter that is passed has at least one element in it.
	 */
	private static Integer findMin(Stack<Integer> inputTrack)	
	{		
		Stack<Integer> tempStack = new Stack<Integer>();		
		int min, x; 
		//set the minimum to the first value in the input track
		min = inputTrack.peek();
		//go through all values in input
		while(!inputTrack.empty())			
		{			
			x = inputTrack.pop();
			//if a smaller value than current min is found, set min to smaller value
			if(x < min)				
			{				
				min = x;				
			}
			//add every value to temp to preserve input
			tempStack.push(x);			
		}
		//move tempStack back to inputTrack
		while(!tempStack.empty())			
		{			
			x =tempStack.pop();			
			inputTrack.push(x);			
		}
		//return smallest value in input
		return min;		
	}	
}
