import java.util.*;

 public class lsearch {
 	public static void main(String[] args){
 		
 		Scanner sc = new Scanner(System.in);
 		linSearch s = new linSearch();
 		System.out.print("size of the array : ");
 		int n = sc.nextInt();
 		int arr[] = new int[n];
		for(int i = 0 ; i<n ; i++){
			System.out.print("value" + i + " = ");
			arr[i] = sc.nextInt();
		}
		System.out.print("Key : ");
		int key = sc.nextInt();
		int pos = s.search(arr,key); 		
 		if(pos != -1){
 			System.out.println(key + " is found at index "+pos);
 		}
 		else{
 			System.out.println(key + " NOT FOUND");
 		}
 	
 	}
 }
 
 
 class linSearch {
 	
 	int search(int a[],int key){
 		for(int i = 0; i<a.length;i++){
 			if(a[i] == key){
 				return i;
 
 			}
 		}
 		return -1;
 	
 	
 	}
 	
 
}
