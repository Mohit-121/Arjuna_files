import java.util.*;
class Bows_Arrows{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String ceaser=sc.nextLine();
		String guess=sc.nextLine();
		String c="";
		ArrayList<Character> d=new ArrayList<Character>();
		int a=0,b=0;
		for(int i=0;i<ceaser.length();i++){
			if(ceaser.charAt(i)==guess.charAt(i)) a++;
			else{
				c+=ceaser.charAt(i);
				d.add(guess.charAt(i));
			}
		}
		for(int i=0;i<c.length();i++){
             if(d.contains(c.charAt(i))){
             	d.remove(d.indexOf(c.charAt(i)));
             	b++;
             }
		}
		System.out.println(a+"A"+b+"B");
	}
}