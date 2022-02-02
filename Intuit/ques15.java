import java.util.*;

public class ques15 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] piles = new int[n];
        int h = scn.nextInt();

        Solution s = new Solution();
        System.out.println(s.minEatingSpeed(piles, h));
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int left = 1;
       int right = 1000000000;
       
       while(left <= right){
           int mid = left + (right - left) / 2;
           if(canEatInTime(piles, mid, h)) right = mid - 1;
           else left = mid + 1;
       }
       return left;
   }
   public boolean canEatInTime(int piles[], int k, int h){
       int hours = 0;
       for(int pile : piles){
           int div = pile / k;
           hours += div;
           if(pile % k != 0) hours++;
       }
       return hours <= h;
   }
}
