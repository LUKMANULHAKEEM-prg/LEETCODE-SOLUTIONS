class Solution {
    public int climbStairs(int n) {
        if(n == 1)return n;

        int dp[] = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        int i = 2;
        while(i <= n){
            dp[i] = dp[i-1] + dp[i-2];
            i++;
        }
        return dp[n];
    }
}