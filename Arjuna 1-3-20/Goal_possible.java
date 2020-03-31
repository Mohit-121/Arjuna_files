import java.util.*;
class Coord implements Comparable<Coord>{
    int i,j,dist;
    String ans;
    Coord(int i,int j,int dist,String ans){
        this.i=i;
        this.j=j;
        this.dist=dist;
        this.ans=ans;
    }
    public int compareTo(Coord c1){
        if(this.dist==c1.dist)
            return this.ans.compareTo(c1.ans);
        return this.dist-c1.dist;
    }
}
class Goal_possible{
    public static String findShortestPath(int maze[][],int sr,int sc,int dr,int dc){
        boolean visited[][]=new boolean[maze.length][maze[0].length];
        PriorityQueue<Coord> pq=new PriorityQueue<>();
        pq.add(new Coord(sr,sc,0,""));
        int dirs[][]={{1,0},{0,-1},{0,1},{-1,0}};
        String d[]={"D","L","R","U"};
        while(!pq.isEmpty()){
            Coord front=pq.remove();
            if(front.i==dr && front.j==dc)
                return front.ans;
            visited[front.i][front.j]=true;
            for(int ind=0;ind<dirs.length;ind++){
                int i=front.i,j=front.j,dist=front.dist;
                String ans=front.ans;
                while(i+dirs[ind][0]>=0 && i+dirs[ind][0]<maze.length
                    && j+dirs[ind][1]>=0 && j+dirs[ind][1]<maze[0].length
                    && maze[i+dirs[ind][0]][j+dirs[ind][1]]!=1){
                    i+=dirs[ind][0];
                    j+=dirs[ind][1];
                    dist++;
                    if(i==dr && j==dc) break;
                }
                if(!visited[i][j])
                    pq.add(new Coord(i,j,dist,ans+d[ind]));
            }
        }
        return "-1";
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt(),c=sc.nextInt();
        int maze[][]=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                maze[i][j]=sc.nextInt();

        int sx=sc.nextInt(),sy=sc.nextInt();
        int dx=sc.nextInt(),dy=sc.nextInt();
        boolean visited[][]=new boolean[r][c];
        System.out.println(findShortestPath(maze,sx,sy,dx,dy));
    } 
}