import java.util.*;
class Baseball{
	public static String[] count(int n){
		if(n==0){
			String [] output={""};
			return output;
		}
	    String temp[]=count(n-1);
	    String output[]=new String[temp.length*2];
	    int k=0;
	    for(int i=0;i<temp.length;i++){
           output[k++]="h"+temp[i];
           output[k++]="m"+temp[i];
	    }
	    return output;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String arr[]=count(n);
		int c=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i].contains("mmm")) c++;
		}
		System.out.println(arr.length-c);
	}
}