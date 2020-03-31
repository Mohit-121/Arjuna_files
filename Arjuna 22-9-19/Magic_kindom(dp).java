import java.util.*;
public class x{
	public static int magicGrid(int input[][],int r,int c){
    int dp[][]=new int[r+1][c+1];
    for(int i=0;i<=r;i++)
    	for(int j=0;j<=c;j++)
    		dp[i][j]=Integer.MAX_VALUE;
    dp[r][c-1]=1;dp[r-1][c]=1;
    for(int i=r-1;i>=0;i--){
    	for(int j=c-1;j>=0;j--){
    		int need=Math.min(dp[i+1][j],dp[i][j+1])-input[i][j];
    		if(need<=0) dp[i][j]=1;
    		else dp[i][j]=need;
    	}
    }
    return dp[0][0];
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
			int m=sc.nextInt();
			int n=sc.nextInt();
			int arr[][]=new int[m][n];
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					arr[i][j]=sc.nextInt();
				}
			}
			System.out.println(magicGrid(arr,m,n));     
}}