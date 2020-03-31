import java.util.*;
class Gold_quality_quantity{
    public static int splitArray(int[] nums, int m) {
        int low = 0, high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (canSplit(nums, m, mid)) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
    public static boolean canSplit(int[] nums, int m, int minSum) {
        int count = 0,sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= minSum) {
                sum = 0;
                count++;
            }
        }
        return count >= m;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String arr[]=sc.nextLine().split(" ");
        int num[]=new int[arr.length];
        for(int i=0;i<num.length;i++)
            num[i]=Integer.parseInt(arr[i]);
        int k=sc.nextInt()+1;
        System.out.println(splitArray(num,k));
    }
}