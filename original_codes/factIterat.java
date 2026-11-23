import java.util.*;

public class factIterat {
    public static int fact(int n){
        int factorial = 1;
        for(int i=1;i<=n;i++){
            factorial*=i;
        }
        return factorial;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number which you want to know what is it's factorial");
        int n = sc.nextInt();
        System.out.println("the factorial of "+n +" is "+fact(n));
    }
}
// Time complexity is O(n)
// as the loop is running n times