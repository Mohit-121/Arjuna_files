import java.util.*;
class Shortened_forms{
    public static TreeSet<String> get_ans(String s){
        if(s.length()==0){
            TreeSet<String> t=new TreeSet<>();
            t.add("");
            return t;
        }
        TreeSet<String> ans=new TreeSet<>();
        for(int i=0;i<s.length();i++){
            String c1=s.substring(0,i+1);
            String c2=String.valueOf(c1.length());
            TreeSet<String> arr=get_ans(s.substring(i+1,s.length()));
            for(String k:arr){
                ans.add(c1+k);
            }
            for(String k:arr){
                if(k.equals("")) ans.add(c2);
                else if(!Character.isDigit(k.charAt(0)))
                    ans.add(c2+k);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(get_ans(s));
    }
}