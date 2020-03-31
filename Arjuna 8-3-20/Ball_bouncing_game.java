import java.util.*;
class Ball_bouncing_game{
    //Dp Solution
    public static int bouncing(int arr[],int m,int ind,int dp[]){
        if(dp[ind]!=-1) return dp[ind];
        int val=1;
        for(int i=1;i<=m;i++){
            if(ind+i>=arr.length || arr[ind+i]>=arr[ind]) break;
            val=Math.max(val,1+bouncing(arr,m,ind+i,dp));
        }
        for(int i=1;i<=m;i++){
            if(ind-i<0 || arr[ind-i]>=arr[ind]) break;
            val=Math.max(val,1+bouncing(arr,m,ind-i,dp));
        }
        return dp[ind]=val;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a[]=sc.nextLine().split(" ");
        int b[]=new int[a.length];
        for(int i=0;i<a.length;i++) b[i]=Integer.parseInt(a[i]);
        int m=sc.nextInt();
        int dp[]=new int[b.length];
        Arrays.fill(dp,-1);
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<b.length;i++)
            ans=Math.max(ans,bouncing(b,m,i,dp));
        System.out.println(ans);
    }
}