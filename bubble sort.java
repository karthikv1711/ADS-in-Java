import java.util.*;

public class bsort {
	public static void main(String[] args){
	
	Scanner sc = new Scanner(System.in);
	Sorts s = new Sorts(); 
	System.out.print("size of the array : ");
	int n = sc.nextInt();
	int arr[] = new int[n];
	for(int i = 0 ; i<n ; i++){
		System.out.print("value" + i + " = ");
		arr[i] = sc.nextInt();
	}
	System.out.print("Unsorted array : "); 
	for(int i = 0 ; i<n ; i++){
		System.out.print(arr[i] + " ");
		
	} 
	s.sort(arr,n);
	System.out.println();
	
	
	}
}



class Sorts {
	void sort(int arr[],int n){
		int temp;
		for(int i = 0 ; i<n-1 ; i++){
			for(int j=0; j<n-1-i ; j++){
				if(arr[j+1]<arr[j]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;		
			
				}
		
			}
	
		}
		System.out.print("\nSorted array : "); 
		for(int i = 0 ; i<n ; i++){
			System.out.print(arr[i] + " ");
		}	
	
		System.out.println();
		
	}

}
