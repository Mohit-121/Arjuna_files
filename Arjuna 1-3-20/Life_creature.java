import java.util.*;
class Life_creature{
    public static int find(int board[][],int i,int j){
        int ans=0;
        if(i-1>=0) ans+=board[i-1][j];
        if(i+1<board.length) ans+=board[i+1][j];
        if(j-1>=0) ans+=board[i][j-1];
        if(j+1<board[0].length) ans+=board[i][j+1];
        if(i-1>=0 && j-1>=0) ans+=board[i-1][j-1];
        if(i+1<board.length && j-1>=0) ans+=board[i+1][j-1];
        if(i-1>=0 && j+1<board[0].length) ans+=board[i-1][j+1];
        if(i+1<board.length && j+1<board[0].length) ans+=board[i+1][j+1];
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt(),c=sc.nextInt();
        int board[][]=new int[r][c];
        int ans[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                board[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==1){
                    int living=find(board,i,j);
                    if(living<2) ans[i][j]=0;
                    else if(living>3) ans[i][j]=0;
                    else ans[i][j]=1;
                }else{
                    if(find(board,i,j)==3)
                        ans[i][j]=1;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}