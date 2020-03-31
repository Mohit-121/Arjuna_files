import java.util.*;
class Coordinate{
    int x,y;
    Coordinate(int i,int j){
        x=i;
        y=j;
    }
}
class Find_Delivery{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int graph[][]=new int[v][v];
        ArrayList<Coordinate> arr=new ArrayList<>();
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                graph[i][j]=sc.nextInt();
                if(graph[i][j]==1)
                    arr.add(new Coordinate(i,j));
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(graph[i][j]==0){
                    int dist=Integer.MAX_VALUE;
                    for(int k=0;k<arr.size();k++){
                        Coordinate temp=arr.get(k);
                        int temp_dist=Math.abs(temp.x-i)+Math.abs(temp.y-j);
                        dist=Math.min(dist,temp_dist);
                    }
                    ans=Math.max(ans,dist);
                }
            }
        }
        if(ans==Integer.MIN_VALUE || ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}