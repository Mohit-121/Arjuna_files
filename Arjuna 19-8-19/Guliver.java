import java.util.*;
class Guliver{
	public static void MinSteps(int sx,int sy,int dx,int dy){
		while(sx!=dx || sy!=dy){
			if(sx>dx){
               System.out.print("U");
               sx--;
			}
			else if(sx<dx){
				System.out.print("D");
				sx++;
			}
			else if(sy>dy){
				System.out.print("L");
				sy--;
			}else{
				System.out.print("R");
				sy++;
			}
		}
	}
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		String x=s.next();
		int sr=0,sc=0,len=0;
		while(len<x.length()){
			int t=x.charAt(len)-'0';
			int dr=t/3,dc=t%3;
			MinSteps(sr,sc,dr,dc);
			sr=dr;sc=dc;
			System.out.print("-");
			len++;
		}
	}
}