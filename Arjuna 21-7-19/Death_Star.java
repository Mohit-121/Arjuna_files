import java.util.*;
class Death_Star{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		int hours=sc.nextInt();
		String b[]=a.split(" ");
		int galaxy[]=new int[b.length];
		for(int i=0;i<b.length;i++){
            galaxy[i]=Integer.parseInt(b[i]);
		}
		double l=1,h=Double.MAX_VALUE;
		double min=Double.MAX_VALUE;
		while(l<=h){
			double mid=Math.floor((l+h)/2);
			double out=0;
			for(int i=0;i<galaxy.length;i++)
				out+=Math.ceil(galaxy[i]/mid);
			if(out>hours) l=mid+1;
			else{
				h=mid-1;
				min=mid;
			}
		}
		System.out.println(Math.round(min));
	}
}