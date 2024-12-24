import java.util.*;
class binsearch{
	int low = 0;
	int high = 0;
	int mid;
	int i,j,temp;
	void sort(int a[]){
		for(i=0;i<a.length-1;i++){
			for(j=0;j<a.length-i-1;j++){
				if(a[j] > a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					}
				}
		
			}
		}
	
	
	int search(int a[],int key){
		int low = 0;
		int high = a.length-1;
		int mid = 0;
		while(low <= high){
			
			mid = (low+high)/2;
			if(a[mid]==key)
				return mid;
			else if (key > a[mid])
				low = mid+1;
			else  
				high = mid-1; 	
		}
		return -1;
			
	}
	
	
			
	
}
	
public class bsearch {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		binsearch b = new binsearch();
		System.out.print("Enter size of an array :");
		int k;
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.print("Enter array of "+n+" elements :");
		for(k=0;k<a.length;k++){
			a[k]=sc.nextInt();
		}
		System.out.print("Enter key :");
		int key = sc.nextInt();
	
		b.sort(a);
		int r = b.search(a,key);
		
		if (r >= 0)
		System.out.println(key+" Found at position "+r);
	else
		System.out.println(key+" is not found");
	
	
	}


}	
