//Carrik McNerlin and Khoa Nguyen
//Writing Assignment 2
//O(n^2)
//Standard InsertSort
import java.util.Random;

public class InsertionSort{
  static int n = 1000;
  public static double A[] = new double[n];
  
  public static void main(String[] args){
    Random rand = new Random();
    
    for (int i = 0; i<n;i++)
     A[i] = rand.nextInt(1000); //generates numbers from 0 to 99

   
   long startTime, endTime;
   
   startTime = System.currentTimeMillis();
   for (int i=1;i<n;i++){
     double key = A[i];
     int j = i-1;
     while (j > -1 && A[j] > key)
     {
       A[j+1] = A[j];
       j--;
     }
     A[j+1] = key;
   }
   endTime = System.currentTimeMillis();
   
//   for (int i=0; i<n; i++)
//   {
//     System.out.println(A[i]);
//   }
   System.out.println("This took " + (endTime - startTime) + " milliseconds to perform.");
  }
}