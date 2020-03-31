import java.util.*;
class Coupon{             //Coupon class to store wait and expiry time of each coupon 
	int wait_time;
	int expiry_time;
	Coupon(int f,int s){
		wait_time=f;
		expiry_time=s;
	}
}
class Attractive_Coupons{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Coupon> Coupons=new ArrayList<>(); // Creating an arraylist of coupons
		for(int i=0;i<n;i++)
			Coupons.add(new Coupon(sc.nextInt(),sc.nextInt()));  //Adding coupon to Coupons class
		Collections.sort(Coupons,Comparator.comparingInt(o->o.expiry_time)); //Sort the coupons based on expiry time
		int ch=0,ans=0,end=0;   
		for(int i=0;i<Coupons.size();i++){
			if(ch+Coupons.get(i).wait_time<=Coupons.get(i).expiry_time){  //If cummulative time is less or equal to expiry_time
                  ans++;
                  end=Coupons.get(i).expiry_time;              //Update the previous expiry_time
                  if(Coupons.get(i).wait_time>end){            
                  	ch=Coupons.get(i).wait_time;                        //If wait_time>end then cummulative time is wait_time
                  }else ch=ch+Coupons.get(i).wait_time;        //Else cuumulative_time is previous cummulative_time+start_time
			}
		}
		System.out.println(ans);                     //Print the no of coupons thus obtained at the end
	}
}