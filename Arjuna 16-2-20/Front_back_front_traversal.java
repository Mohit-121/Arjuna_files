import java.util.*;
class Front_back_front_traversal{
    static boolean hasPath=false;  //Indicates if there is any path or not
    public static int cal_cost(int graph[][],int r1,int c1,int r2,int c2){
        //If we are on the same row and column return value only once at that cell
        if(r1==r2 && c1==c2){
            return graph[r1][c1];
        }
        //else return value for both the cells currently traversing
        return graph[r1][c1]+graph[r2][c2];
    }
    //Checks if a particular cell is safe to traverse or not
    public static boolean isSafe(int graph[][],int r,int c){
        if(r>=0 && r<graph.length && c>=0 && c<graph.length && graph[r][c]!=-1)
            return true;
        return false;
    }
    public static int getMangoes(int graph[][],int dp[][][][],int r1,int c1,int r2,int c2){
        //If we reach the destination with both paths
        if(r1==graph.length-1 && c1==graph.length-1 && r2==graph.length-1 && c2==graph.length-1){
            hasPath=true;
            return 0;
        }
        // If already calculated return that value
        if(dp[r1][c1][r2][c2]!=-1)
            return dp[r1][c1][r2][c2];
            
        dp[r1][c1][r2][c2]=Integer.MIN_VALUE;
        // In first way we move right and in 2nd we move down
        if(isSafe(graph,r1,c1+1) && isSafe(graph,r2+1,c2))
           dp[r1][c1][r2][c2]=Math.max(dp[r1][c1][r2][c2],
            cal_cost(graph,r1,c1+1,r2+1,c2)+getMangoes(graph,dp,r1,c1+1,r2+1,c2));

        // In first way we move right and in second way as well we move right
        if(isSafe(graph,r1,c1+1) && isSafe(graph,r2,c2+1))
            dp[r1][c1][r2][c2]=Math.max(dp[r1][c1][r2][c2],
            cal_cost(graph,r1,c1+1,r2,c2+1)+getMangoes(graph,dp,r1,c1+1,r2,c2+1));

        // In first way we move down and in 2nd we move right
        if(isSafe(graph,r1+1,c1) && isSafe(graph,r2,c2+1))
             dp[r1][c1][r2][c2]=Math.max(dp[r1][c1][r2][c2],
                cal_cost(graph,r1+1,c1,r2,c2+1)+getMangoes(graph,dp,r1+1,c1,r2,c2+1));

        // In first way we move down and in 2nd way as well we move down
        if(isSafe(graph,r1+1,c1) && isSafe(graph,r2+1,c2))
             dp[r1][c1][r2][c2]=Math.max(dp[r1][c1][r2][c2],cal_cost(graph,r1+1,c1,r2+1,c2)+getMangoes(graph,dp,r1+1,c1,r2+1,c2));
        
        //Resulting dp will have the most optimal solution out of the
         //four different choices of path taken
        return dp[r1][c1][r2][c2];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        //Creation of graph for the given mangoes
        int graph[][]=new int[v][v];
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                graph[i][j]=sc.nextInt();
        //Creation of dp array which stores corresponding max_coins
        // for 2 path with row1 and col1 and row2 and col2
        int dp[][][][]=new int[v][v][v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                for(int k=0;k<v;k++){
                   for(int l=0;l<v;l++){
                       dp[i][j][k][l]=-1;
                   }
                }
            }
        }
        // If the start and end gates have mangoes add them to answer
        int ans=graph[v-1][v-1]+graph[0][0];
        graph[v-1][v-1]=0;
        graph[0][0]=0;
        int final_ans=getMangoes(graph,dp,0,0,0,0)+ans;
        // If the graph doesn't have any path from start to end print 0
        if(!hasPath) System.out.println(0);
        // Else print the maximum count of mangoes collected
        else System.out.println(final_ans);    
    }
}