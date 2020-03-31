import java.util.*;
class Allies{
    public static int bfs(int graph[][],int src,int dist){
        boolean visited[]=new boolean[graph.length];
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        visited[src]=true;
        int count=0,child=1;
        while(!q.isEmpty()){
            child=q.size();
            dist--;
            while(child-->0){
                int front=q.remove();
                for(int i=0;i<visited.length;i++){
                    if(!visited[i] && graph[front][i]==1){
                        visited[i]=true;
                        if(dist==0) count++;
                        q.add(i);
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt(),e=sc.nextInt();
        int graph[][]=new int[v][v];
        for(int i=0;i<e;i++){
            int src=sc.nextInt(),dest=sc.nextInt();
            graph[src][dest]=1;
            graph[dest][src]=1;
        }
        int q=sc.nextInt();
        for(int i=0;i<q;i++){
            int src=sc.nextInt(),dist=sc.nextInt();
            System.out.println(bfs(graph,src,dist));
        }
    }
}