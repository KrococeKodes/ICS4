//importing scanner
import java.util.*;

public class BinarySearchAlgorithm {
	/*
	 * int binarySearchNonRecursive(int searchValue, int[] inputArray)
	 * 
	 * returns int - the index of the searchValue (-1 if not found)
	 *
	 * searchValue -> the target value
	 * 
	 *	inputArray -> the array to serach
	 *
	 *This method uses binary search in a looping manner instead of recursion
	 */
	
    public static int binarySearchNonRecursive(int searchValue, int[] inputArray)
    {
        int top;
        int bottom;
        int middle;
        
        top = inputArray.length-1;
        bottom = 0;
        int searchIndex = -1;
        while (bottom <= top && searchIndex == -1)
        {
            middle = (top+bottom)/2;
            
            if (inputArray[middle] == searchValue)
            {
                searchIndex = middle;

                return searchIndex;
            }
            else if (searchValue > inputArray[middle])
            {
                bottom = middle+1;
            }
            else
            {
                top = middle-1;
            }
        }
        
        return searchIndex;
    }
    
    /*
	 * int binarySearchNonRounded(int searchValue, int[] inputArray)
	 * 
	 * returns int - the index of the searchValue (or closest if not found, favoring the lower index)
	 *
	 * searchValue -> the target value
	 * 
	 *	inputArray -> the array to search
	 *
	 *This method uses binary search in a looping manner instead of recursion, not returning -1 and instead the closest lower index
	 */
    public static int binarySearchRounded(int searchValue, int[] inputArray)
    {
        int top;
        int bottom;
        int middle;
        
        top = inputArray.length-1;
        bottom = 0;
        int searchIndex = -1;
        while (bottom <= top && searchIndex == -1)
        {
            middle = (top+bottom)/2;
            
            if (inputArray[middle] == searchValue)
            {
                searchIndex = middle;

                return searchIndex;
            }
            else if (searchValue > inputArray[middle])
            {
                bottom = middle+1;
            }
            else
            {
                top = middle-1;
            }
        }
        
        //no value found
        if (searchValue > inputArray[inputArray.length-1])
        {
        	return inputArray.length-1;
        } 
        else if (searchValue < inputArray[0])
        {
        	return 0;
        }
        else
        {
        	
        	if (Math.abs(inputArray[bottom]-searchValue) <= Math.abs(inputArray[top]-searchValue))
            {
            	return bottom;
            }
            else
            {
            	return top;
            }
        }
        
    }
    
    
    
  
    /*
	 * int binarySearchRecursion(int bottom, int top, int searchValue, int[] inputArray)
	 * 
	 * returns int - the index of the searchValue (-1 if not found)
	 *
	 * searchValue -> the target value
	 * 
	 * inputArray -> the array to serach
	 *
	 * bottom -> bottom bound of the binary serach
	 * 
	 * top -> top bound of the binary search
	 *
	 * This method uses binary search in a looping manner instead of recursion
	 */
	
    public static int binarySearchRecursion(int bottom, int top, int searchValue, int[] inputArray)
    {
    	int middle;
    	if (bottom > top)
    	{
    		return -1;
    	}
    	middle = (top+bottom)/2;
    	if (inputArray[middle] == searchValue)
    	{
    		return middle;
    	}
    	else
    	{
    		if (searchValue > inputArray[middle])
    		{
    			return binarySearchRecursion(middle+1, top, searchValue, inputArray);
    		}
    		else
    		{
    			return binarySearchRecursion(bottom, middle-1, searchValue, inputArray);
    		}
    	}
    }
    
    /*
     * void bubbleSort(int[] input Array)
     * 
     * returns nothing (Sorts the array, a pass-by object)
     * 
     * int[] inputArray -> the array to be sorted
     * 
     * This method sorts the array using bubble, o(n^2) comparing following neighbouring elements and corresponding swaps
     */
    public static void bubbleSort(int[] inputArray)
    {
    	int swapValue;
    	boolean isSorted;
    	int upperBound;
    	isSorted = false;
    	upperBound = inputArray.length-1;
    	
    	while (upperBound > 0 && !isSorted)
    	{
    		isSorted = true;
    		for (int i = 0; i < upperBound; i++)
        	{
        		if (inputArray[i+1] < inputArray[i])
        		{
        			isSorted = false;
        			swapValue = inputArray[i];
        			inputArray[i] = inputArray[i+1];
        			inputArray[i+1] = swapValue;
        		}
        	}
    		upperBound--;
    	}
    	
    	
    }
    public static void main(String[] args)
    {
    	//declaring scanner
    	Scanner sc = new Scanner(System.in);
    	int intInput;
    	//test array
    	final int TEST_ARRAY_LENGTH = 20;
    	int[] testArray = new int[TEST_ARRAY_LENGTH];
    	
    	
    	
    	//filling the array with random integers 1-100
    	for (int i = 0; i < TEST_ARRAY_LENGTH; i++)
    	{
    		testArray[i] = (int)(Math.random()*100+1);
    		
    	}
    	
    	//sorting with bubble sort
    	bubbleSort(testArray);
    	
    	
    	//printing the array
    	System.out.print("{");
    	for (int i = 0; i < TEST_ARRAY_LENGTH; i++)
    	{
    		System.out.print(""+testArray[i]+",");
    	}
    	System.out.println("}");
    	
    	//prompting user input
    	System.out.print("\nEnter a value to check if it is in the array: ");
    	intInput = sc.nextInt();
    	
    	//output
    	if (binarySearchNonRecursive(intInput, testArray) == -1)
    	{
    		System.out.println("\nUsing Binary search with loops, "+intInput+" does not appear");
    	}
    	if (binarySearchRecursion(0,testArray.length-1, intInput, testArray) == -1)
    	{
    		System.out.println("\nUsing Binary search with recursion, "+intInput+" does not appear");
    	}
    	if (binarySearchNonRecursive(intInput,testArray) != -1)
    	{
    		System.out.println("\nUsing Binary search with loops, "+intInput+" is at index "+binarySearchNonRecursive(intInput,testArray));
    	}
    	if (binarySearchRecursion(0, testArray.length-1, intInput, testArray) != -1)
    	{
    		System.out.println("\nUsing Binary search with recursion, "+intInput+" is at index "+binarySearchRecursion(0,testArray.length-1,intInput,testArray));
    	}	
    	
    	sc.close();
    	
    }
}