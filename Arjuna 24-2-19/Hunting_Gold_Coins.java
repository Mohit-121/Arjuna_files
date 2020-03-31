import java.util.*;
public class Hunting_Gold_Coins{
static int max(int a,int b,int c) { //max function for 3 integers
    if(a>b&&a>c) return a;
    else if(b>a&&b>c) return b;
    else return c;
}
static int max(int a,int b){   //max function for 2 integers
	if(a>b) return a;
	else return b;
}
public static void main(String[] args) {
Scanner s=new Scanner(System.in);
int n=s.nextInt();
int arr[][]=new int[n][n];
for(int i=0;i<n;i++) {
for(int j=0;j<n;j++) {
arr[i][j]=s.nextInt();
}
}
for(int i=arr.length-1;i>0;i--) {
for(int j=0;j<arr[i].length;j++) {
if(j==0) {
int m=max(arr[i][j],arr[i][j+1]); //Finding out the max of elt and its right partner
arr[i-1][j]+=max; //Adding the max to above row
}
else if(j==n-1) {
int m=max(arr[i][j],arr[i][j-1]);  //Finding max of elt an its left partner
arr[i-1][j]+=max;    //Adding the max to the above row
}
else {
int m=max(arr[i][j],arr[i][j+1],arr[i][j-1]); //Finding out max of elt its left and right partner
arr[i-1][j]+=m; //Adding to the max of the above row
}
}}
int maxi=arr[0][0];
for(int i=1;i<n;i++) {
if(arr[0][i]>maxi) maxi=arr[0][i]; //Finding out the max in the 1st row
}
System.out.println(maxi);
}
}
