//Carrik McNerlin and Khoa Nguyen
//Writing Assignment 2
//O(nlgn)
//QuickSortentire array.

import java.util.Random;
public class QuickSort
{
 public static void main (String[] args)
  {
    int n = 100000; //arbitrarily large number, can be changed to show speeds at different sizes of datasets
    int A[] = new int[n];
    Random rand = new Random();
    
    for (int i = 0; i<n;i++)
      A[i] = rand.nextInt(100); //generate an array of n numbers from 0 to 99
  
    
    long StartTime, EndTime;
    QuickSort qs = new QuickSort(); //create an instance of the quicksort
    
    StartTime = System.currentTimeMillis();
    qs.quickSort(A, 0, n-1); //our actual sorting happens here
    EndTime = System.currentTimeMillis();
    
    System.out.println("\nThis took " + (EndTime - StartTime) + " milliseconds.");
   }  //end main

 
 
  /*
   * Inputs:
   *   p = lower boundary
   *   r = upper boundary
   * Output: sorted partition
   * Called by: quickSort
   * Calls: NONE
   */
  int Partition(int A[], int p, int r)
  {
    int q = p;
    for (int i = p; i<r;i++)
    {
      if (A[i] <=A[r])
      {
        int temp = A[q]; //hold A[i]
        A[q] = A[i];     //write over A[i]
        A[i] = temp;     //finish replacement
        q++;
      }
    }
    
    int temp = A[q];
    A[q] = A[r];
    A[r] = temp;
    return q;
  }//end Partition
  
 
  
  /*
   * Inputs:
   *   p = lower boundary
   *   r = upper boundary
   * Called by: main
   * Calls: Partition, [self]
   */
  void quickSort(int A[], int p, int r)
  {
    if (p < r)
    {
     int q = Partition(A,p,r); //find middle
     quickSort(A,p,q-1); //do it again on lower half
     quickSort(A,q+1, r); //and upper half
    }
  }//end quickSort
  
  
}//end class