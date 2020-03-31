import java.util.*; 
class Hercule
{
//Most efficient iterative solution
public static int decode(String str){
            int a[]=new int[str.length()+1];
            a[0]=1;a[1]=1;
            for(int j=2;j<=str.length();j++){
                if(str.charAt(j-1)!='0')a[j]+=a[j-1];
                int k=Integer.parseInt(str.substring(j-2,j));
                if(k<=26&&k>=10)a[j]+=a[j-2];
            }
        return a[str.length()];
    }

/* Most Efficient recursive solution
static int num_codes(String n,int arr[]){
   if(n.length()==0 || n.length()==1) return 1;
   if(arr[n.length()]>0) return arr[n.length()];
   int count=0;
   if(n.charAt(0)>'0')
      count=num_codes(n.substring(1),arr);
   if(n.charAt(0)=='1' || (n.charAt(1)=='2' && n.charAt(2)<'7'))
   	count+=num_codes(n.substring(2),arr);
   arr[n.length()]=count;
   return count;
}
*/

/*Recursive solution which takes exponential time(2^n)
static int decode(String n) 
{ 
	if(n.length()==0 || n.length()==1) return 1;
	int count=0;
	if(n.charAt(0)>'0')
		count=decode(n.substring(1));
	int f=Integer.parseInt(n.substring(0,2));
	if(f>=10 && f<=26) count+=decode(n.substring(2));
	return count; 
}*/ 

public static void main (String[] args) 
{
    Scanner sc=new Scanner(System.in); 
	String s=sc.next();
	System.out.println(decode(s)); 
} 
}