import java.util.*;
class Shortest_encoding{
    public static String get_encoding(String s){
        String ans[][]=new String[s.length()][s.length()];
        for(int len=0;len<s.length();len++){
            for(int i=0;i<s.length()-len;i++){
                int j=i+len;
                String sub=s.substring(i,j+1);
                if(j-i<4) ans[i][j]=sub;
                else{
                    ans[i][j]=sub;
                    for(int k=i;k<j;k++){
                        String part=ans[i][k]+ans[k+1][j];
                        ans[i][j]=(part.length()<ans[i][j].length())?part:ans[i][j];
                    }
                    for(int k=0;k<sub.length();k++){
                        String subseq=sub.substring(0,k+1);
                        if(sub.length()%subseq.length()==0
                            && sub.replaceAll(subseq,"").length()==0){
                            String ansseq=sub.length()/subseq.length() + "[" + ans[i][i+k] + "]";
                            if(ansseq.length()<ans[i][j].length())
                                ans[i][j]=ansseq;
                        }
                    }
                }
            }
        }
        return ans[0][s.length()-1];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(get_encoding(s));
    }
}