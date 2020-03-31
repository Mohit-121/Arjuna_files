import java.util.*;
class Annual_sale{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		//Take inputs
		int L=sc.nextInt(),A=sc.nextInt(),N=sc.nextInt(),D=sc.nextInt();
		//Base conditions which when not satisfied can't avail any offer
		if(N<D || N>L){
			System.out.println(-1);
			continue;
		}
		// Deal with the special case
		if(D==1) System.out.println(L*A);
		else{
			// The number of accessories
	        // A : a1
	        // A-1 to A-n: a2
	        // A-n-1: a3
			int max=-1;
			int a2max=(N-1)/(D-1);
			// Loop start from maximun a2
			for(int a2=a2max;a2>=1;a2--){
				int a1=N+(a2-1)-a2*(D-1);
				int n=(L-a1)/a2;
				int a3=(L-a1)%a2;
				// Break when the type of accessories (A) is not enough
				if(n>A-1 || (n==A-1 && a3>0)) break;
				// Caclulate cost
				int sum=A*a1+(A-1+A-n)*n/2*a2+a3*(A-n-1);
				// Break when cost starts decreasing
				if(sum<=max) break;
				max=sum;
			}
			System.out.println(max);
		}}
	}
}