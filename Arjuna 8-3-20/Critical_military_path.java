import java.util.*;
class Critical_military_path{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt(),c=sc.nextInt();
        int graph[][]=new int[r+2][c+2];
        for(int i=1;i<=r;i++)
            for(int j=1;j<=c;j++)
                graph[i][j]=sc.nextInt();

        int total=0,o_cell=0,ex_edges=0;
        for(int i=1;i<graph.length;i++){
            for(int j=1;j<graph[0].length;j++){
                if(graph[i][j]==1){
                    o_cell++;
                    if(graph[i][j-1]==1) ex_edges++;
                    if(graph[i][j+1]==1) ex_edges++;
                    if(graph[i-1][j]==1) ex_edges++;
                    if(graph[i+1][j]==1) ex_edges++;
                }
            }
        }
        System.out.println(4*o_cell-ex_edges);
    }
}