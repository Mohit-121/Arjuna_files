import java.util.*;
class Minimum_daily_accomplishment{
    //Recursive Solution
    public static int compress(int l[],int d,int ind,int maxi,int val,int count){
        if(ind==l.length && count==d) return val;
        if(ind==l.length) return Integer.MAX_VALUE;
        int o1=compress(l,d,ind+1,l[ind],val+l[ind],count+1);
        int o2=0;
        if(maxi<l[ind]){
            o2=compress(l,d,ind+1,l[ind],val-maxi+l[ind],count);
        }else
            o2=compress(l,d,ind+1,maxi,val,count);
        return Math.min(o1,o2);
    }
    //Dp solution
    public static int compress1(int arr[],int d,int ind,int dp[][]){
        if(d==0 && ind==arr.length) return 0;
        if(d==0 || ind==arr.length) return Integer.MAX_VALUE/2;
        if(dp[ind][d]!=-1) return dp[ind][d];
        int ans=Integer.MAX_VALUE/2;
        int max=arr[ind];
        for(int i=ind;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            ans=Math.min(ans,max+compress1(arr,d-1,i+1,dp));
        }
        return dp[ind][d]=ans;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int order[]=new int[s.length];
        for(int i=0;i<s.length;i++)
            order[i]=Integer.parseInt(s[i]);
        int d=sc.nextInt();
        if(order.length<d){
            System.out.println(-1);
            return;
        }
        int dp[][]=new int[order.length][d+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        System.out.println(compress1(order,d,0,dp)); //Dp Solution
        System.out.println(compress(order,d,0,0,0,0));  //Recursive Solution
    }
}