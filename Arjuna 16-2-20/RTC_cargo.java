import java.util.*;
class RTC_cargo{
    //BFS function which prints path from source to destination
    public static void findShortestPath(int graph[][],int src,int dest){
        boolean visited[]=new boolean[graph.length];
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        //Map is used to keep track of who added that particular node
        visited[src]=true;
        q.add(src);
        int level=1;   //Indicates at which level a node was found
        String ans="";
        while(!q.isEmpty()){
            int child=q.size();    //No of vertices added by a particular vertex
            level++;
            while(child-->0){
                int front=q.remove();
                for(int i=1;i<graph.length;i++){
                    if(!visited[i] && graph[front][i]==1){
                        visited[i]=true;
                        map.put(i,front);  //map contains the added vertex and it's parent
                        q.add(i);
                        if(i==dest){  //If we find the destination we print the path and break out of the traversal
                            System.out.println(level);
                            ans=String.valueOf(dest);
                            while(map.get(i)!=src){    //Till we don't reach source vertex we continue traversal
                                ans=String.valueOf(map.get(i))+" "+ans;
                                i=map.get(i);
                            }
                            ans=String.valueOf(src)+" "+ans;
                            System.out.println(ans);   //Print the answer and return from the function
                            return;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt(),e=sc.nextInt(),s=sc.nextInt(),t=sc.nextInt();
        int graph[][]=new int[v+1][v+1];
        for(int i=0;i<e;i++){
            int src=sc.nextInt(),dest=sc.nextInt();
            graph[src][dest]=1;
            graph[dest][src]=1;
        }
        int src=sc.nextInt(),dest=sc.nextInt();
        //If source is also destination print level1 and print the source
        if(src==dest){
            System.out.println(1);
            System.out.println(src);
        }
        //Print the shortest path from source to destination
        else findShortestPath(graph,src,dest);
    }
}