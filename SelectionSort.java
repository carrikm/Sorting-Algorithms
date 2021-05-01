//Carrik McNerlin and Khoa Nguyen 
//Writing Assignment 2 
//O(n^2) 
//Standard SelectionSort
import java.util.Random;
import java.util.Scanner; 

class SelectionSort
{ 
    /*
     * Input: an array
     * Output: none, sorts inputted array
     * Called by: 
     * Calls: NONE
     */
    void sort(double arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min]) 
                    min = j; 
  
            // Swap the found minimum element with the first 
            // element 
            double temp = arr[min]; 
            arr[min] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
  
    /*
     * Input: an array
     * Output: none, prints inputted array
     * Called by: main
     * Calls: NONE
     */
    void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
    /* Driver code to run above functions
     * Input: 2 characters
     * This is an implementation of the Selection Sort algorithm.
     * Calls: sort(), optional call to printArray
     */
    public static void main(String args[]) throws InterruptedException
    { 
      int n = 100000; //arbitrarily large, change to show different 
      double A[] = new double[n];
      Random rand = new Random();
      Scanner input = new Scanner(System.in);
      
      SelectionSort sorter = new SelectionSort();
      
      //populate array A with values from 0-999
      for (int i = 0; i<n;i++){
        A[i] = rand.nextInt(1000);
      }
      
      //give option to see array before sorting
      System.out.println("Would you like to print the initial array?");
      char print = input.nextChar();
      if (print == 'y' | print == 'Y'){
        printArray(A);
      }
      
      
      //variables to time our algorithm
      long startTime, endTime, timeElapsed;
     
      startTime = System.currentTimeMillis();
      //sort the array
      sorter.sort(A);
      endTime = System.currentTimeMillis();
      
      
      timeElapsed = endTime - startTime;
        
      System.out.println("Execution time in milliseconds: " + timeElapsed);
      
      //give option to see the array after sorting
      System.out.println("Would you like to print the sorted array?");
      print = input.nextChar();
      if (print == 'y' | print == 'Y'){
        printArray(A);
      }
    } 
}