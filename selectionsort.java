import java.util.*;

public class selsort {
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
	void sort(int a[],int n){
		int i,j,temp,minpos;
		for(i = 0 ; i<n-1 ; i++){
			minpos = i;
			for(j=i+1; j<n ; j++){
				if(a[j] < a[minpos]){
					minpos = j;
				}
				
		
			}
			temp = a[i];
        		a[i] = a[minpos];
        		a[minpos] = temp;
	
		}
		System.out.print("\nSorted array : "); 
		for(i = 0 ; i<n ; i++){
			System.out.print(a[i] + " ");
		}	
	
		System.out.println();
		
	}
	
}
