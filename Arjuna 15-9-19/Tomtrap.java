import java.util.*;
class x{
	public static int board[][]=new int[0][0];
	public static int sol[][]=new int[0][0];
	static int min=Integer.MAX_VALUE;
	public static void shortestpath(int row,int col,int dr,int dc){
		if(row==dr && col==dc){
			int count=0;
			for(int i=0;i<board.length;i++){
				for(int j=0;j<board.length;j++){
					if(sol[i][j]==1) count++;
				}
			}
			if(min>count) min=count;
			return;
		}
		if(row<0 || row>=board.length || col<0 || col>=board.length || board[row][col]==0
			|| sol[row][col]==1)
			return;
		sol[row][col]=1;
		shortestpath(row+1,col,dr,dc);
		shortestpath(row-1,col,dr,dc);
		shortestpath(row,col+1,dr,dc);
		shortestpath(row,col-1,dr,dc);
		sol[row][col]=0;
	}
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		board=new int[n][n];
		int a[][]=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				board[i][j]=s.nextInt();
				a[i][j]=board[i][j];
			}
		}
		int mini=0,sr=0,sc=0,dr=0,dc=0,count=0;
		while(mini!=Integer.MAX_VALUE){
			mini=Integer.MAX_VALUE;
			sol=new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(a[i][j]>1 && mini>a[i][j]){
						mini=a[i][j];
						dr=i;dc=j;
					}
				}
			}
			if(mini!=Integer.MAX_VALUE){
				a[dr][dc]=0;
				shortestpath(sr,sc,dr,dc);
				if(min==Integer.MAX_VALUE){
				    count=-1;
				    break;
				}
				count+=min;
				min=Integer.MAX_VALUE;
			}
			sr=dr;sc=dc;
		}
		System.out.println(count);
	}
}