import java.util.*;
class Suggest_Email_Id{
	static boolean contains(String a[],int n,String x) {
		for(int i=0;i<n;i++) {
			if(a[i].equals(x)) return true;
		}
		return false;
	}
	static int index(String a[],int n,String x) {
		int ind=-1;
		for(int i=0;i<n;i++) {
			if(a[i].equals(x)) {
				ind=i;
			}
		}
		return ind;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int count[]=new int[n];
		String name[]=new String[n];
		for(int i=0;i<n;i++) {
			String f=sc.next();
			name[i]=f;
			if(contains(name,i,f)) {
				int ind=index(name,i,f);
				count[i]=count[ind]+1;
			}
			else {
				count[i]=0;
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(name[i]);
			if(count[i]!=0) System.out.println(count[i]);
			else System.out.println();
		}
		}}
