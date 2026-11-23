import java.util.*;
public class bubbleSort{

    public static void bubble_sort(int arr[]){
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }

    }
     public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        bubble_sort(arr);
        printArr(arr);


    }
}

// Time complexities
// best O(n)
// avg O(n^2)
// worst O(n^2)