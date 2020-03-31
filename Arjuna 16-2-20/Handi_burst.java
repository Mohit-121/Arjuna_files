import java.util.*;
class Handi_burst{
    public static int get_ans(ArrayList<Integer> arr,HashMap<ArrayList<Integer>,Integer> map){
        //If size<=2 then return 0
        if(arr.size()<=2) return 0;
        //If we have already calculated answer for the subproblem then return that answer
        if(map.containsKey(arr)) 
            return map.get(arr);
        int final_ans=0;
        for(int i=1;i<arr.size()-1;i++){
            int ans=arr.get(0)*arr.get(i)*arr.get(arr.size()-1);
            ArrayList<Integer> left=new ArrayList<>();
            for(int j=0;j<=i;j++) left.add(arr.get(j));
            //Break the handi on the left side and add to answer
            ans+=get_ans(left,map);
            ArrayList<Integer> right=new ArrayList<>();
            for(int j=i;j<arr.size();j++) right.add(arr.get(j));
            //Break the handi on the right side and add to answer
            ans+=get_ans(right,map);
            //Final_ans is the maximum of the answer by breaking given handi
            //And maximum result present already
            final_ans=Math.max(ans,final_ans);
        }
        // We then store the answer corresponding to the array and return it
        map.put(arr,final_ans);
        return final_ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        //Addition of imaginary zeros to the start and end of the arraylist
        arr.add(1);
        for(int i=1;i<=n;i++)
            arr.add(sc.nextInt());
        arr.add(1);
        //Map keeps track of whether an array has occured previously
        //Used to store the value corresponding to an arraylist
        HashMap<ArrayList<Integer>,Integer> map=new HashMap<>();
        System.out.println(get_ans(arr,map));
    }
}