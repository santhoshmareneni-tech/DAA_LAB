import java.util.*;
public class tab_0_1_knapsack {//O(nW)

    static boolean[][] keep;

    public static int knapsackTab(int val[] , int wt[] , int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        keep = new boolean[n + 1][W + 1];

        for(int i=0;i<
            dp.length;i++){ //0th col
            dp[i][0] = 0;
        }
        for(int j=0;j<dp.length;j++){ //0th row
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j =1;j<W+1;j++){
                int v = val[i-1]; //ith item val
                int w = wt[i-1]; //ith tem wt

                if(w<=j){ //valid
                    int incProfit = v  + dp[i-1][j-w]; // it's own profit and 
                    int excProfit = dp[i-1][j]; //upper value

                    dp[i][j] = Math.max(incProfit, excProfit);
                    keep[i][j] = incProfit > excProfit;

                }else{//invalid
                     int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][W]; //last col last row
    }

    public static void print(int dp[][]){
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printSelectedItems(int val[],int wt[], int W) {
        int i = wt.length;
        int j = W;

        System.out.println("Selected items:");

        while (i > 0 && j > 0) {
            if (keep[i][j]) {
                System.out.println("Item " + i + ":Weight = "+ wt[i-1] + ":profit = "+ val[i-1]);
                j -= wt[i - 1];
            }
            i--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter capacity of the bag: ");
        int W = sc.nextInt();
        
        System.out.println("Enter the no.of items of the bag: " );
        int n = sc.nextInt();

        int val[] = new int[n];
        System.out.println("enter the values of the profit");
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        int wt[] = new int[n];
        System.out.println("enter the values of the weights");
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        // int val[] = {15,14,10,45,30};
        // int wt[] = {2,5,1,3,4};
        // int W = 7;
        int dp[][] = new int [val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        // System.out.println(knapsack(val, wt, W, val.length));
        int maxProfit = knapsackTab(val, wt, W);
        System.out.println("Maximum profit = " + maxProfit);
        printSelectedItems(val,wt, W);
        
    }
}