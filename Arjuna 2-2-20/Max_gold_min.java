import java.util.*;
public class Max_gold_min{
    static int ans=Integer.MIN_VALUE;
    public static void findMinimumPath(int edges[][],int i,int j,int sum){
        if(i==edges.length-1 && j==edges[0].length-1){
            ans=Math.max(ans,sum);
            return;
        }
        if(i==0 && j==0){
            if(i+1<edges.length) findMinimumPath(edges,i+1,j,sum);
            if(j+1<edges[0].length) findMinimumPath(edges,i,j+1,sum);
        }else{
            if(i+1<edges.length) findMinimumPath(edges,i+1,j,Math.min(sum,edges[i][j]));
            if(j+1<edges[0].length) findMinimumPath(edges,i,j+1,Math.min(sum,edges[i][j]));
        }
        }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();
        int edges[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                edges[i][j]=s.nextInt();
            }
        }
        findMinimumPath(edges,0,0,Integer.MAX_VALUE);
        System.out.println(ans);
    }
}