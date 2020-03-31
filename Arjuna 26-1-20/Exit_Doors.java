import java.util.*;
class Exit_Doors{
	public static boolean isSafe(int doors[][],int i,int j,boolean visited[][]){
		if(i<0 || i>=doors.length || j<0 || j>=doors[0].length || visited[i][j] ||
			doors[i][j]==-1)
			return false;
		return true;
	}
	public static int min_dist(int doors[][],int i,int j,boolean visited[][]){
		int dir_x[]={1,-1,0,0};
		int dir_y[]={0,0,1,-1};
		if(doors[i][j]==0) return 0;
		int ans=9999;
		visited[i][j]=true;
		for(int ind=0;ind<4;ind++){
			int x=dir_x[ind],y=dir_y[ind];
			if(isSafe(doors,i+x,j+y,visited)){
				ans=Math.min(ans,min_dist(doors,i+x,j+y,visited)+1);
			}
		}
		visited[i][j]=false; 
		return ans;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt(),c=sc.nextInt();
		int doors[][]=new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				doors[i][j]=sc.nextInt();
			}
		}
		int ans[][]=new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				int x=0;
				boolean visited[][]=new boolean[r][c];
				if(doors[i][j]==-1 || doors[i][j]==0
					|| (x=min_dist(doors,i,j,visited))==9999)
					ans[i][j]=doors[i][j];
				else
					ans[i][j]=x;
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}