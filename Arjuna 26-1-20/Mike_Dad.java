import java.util.*;
class Mike_Dad{
	public static ArrayList<Integer> findFactors(int x,int q){
		ArrayList<Integer> arr=new ArrayList<>();
		for(int i=1;i<=q;i++)
			if(x%i==0) arr.add(i);
		return arr;
	}
	public static int findMin(ArrayList<ArrayList<Integer>> arr,boolean[] visited){
		int pos=-1,min=Integer.MAX_VALUE;
		for(int i=0;i<arr.size();i++){
			if(!visited[i] && arr.get(i).size()>0 && min>arr.get(i).size())
				pos=i;
		}
		return pos;
	}
	public static void remove(ArrayList<ArrayList<Integer>> arr,int x){
		for(int i=0;i<arr.size();i++){
			if(arr.get(i).contains(x))
				arr.get(i).remove(new Integer(x));
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt(),q=sc.nextInt();
		ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
		for(int i=0;i<p;i++){
			int x=sc.nextInt();
			ArrayList<Integer> temp=findFactors(x,q);
			arr.add(temp);
		}
		boolean visited[]=new boolean[p];
		int ans=0;
		while(true){
			int pos=findMin(arr,visited);
			if(pos!=-1){
				visited[pos]=true;
				int x=arr.get(pos).get(arr.get(pos).size()-1);
				ans++;
				remove(arr,x);
			}else break;
		}
		System.out.println(ans);
	}
}



