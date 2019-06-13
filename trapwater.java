import java.io.*;
import java.util.*;

public class trapwater{
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		
		int n = sc.nextInt();
		int i;
		int arr[] = new int[n];
		System.out.println("Enter the elements sequentially");
		for(i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		
		calculateWaterTrapped(arr,n);
	}
	
	public static void calculateWaterTrapped(int arr[], int n){
		int i,water=0;
		int left[] = new int[n];
		int right[]= new int[n];
		left[0]=arr[0];
		right[n-1]=arr[n-1];
		
		//finding left limit
		for(i=1;i<n;i++){
			if(arr[i]>left[i-1])
				left[i]=arr[i];
			else
				left[i]=left[i-1];
		}
		
		//finding right limit
		for(i=n-2;i>=0;i--){
			if(arr[i]>right[i+1])
				right[i]=arr[i];
			else
				right[i]=right[i+1];
		}
		
		//calculate water
		for(i=1;i<n-1;i++){
			water=water+((left[i]<right[i]?left[i]:right[i])-arr[i]);
		}
		
		System.out.println(water);
	}
	
}
