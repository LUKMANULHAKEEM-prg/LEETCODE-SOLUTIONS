class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==1){
            if(nums[0]==1)return 2;
            else return 1;
        }
        int limit=nums.length-1;
        int i=0;
        while(i<nums.length){
            if(nums[i]>0 && nums[i]-1 != i && nums[i]-1 <= limit && nums[i]!=nums[nums[i]-1]){
                int x=nums[i];
                nums[i]=nums[x-1];
                nums[x-1]=x;
                
            }else i++;
        }
        int j=0;
        for(j=0;j<nums.length;j++){
            if(nums[j]-1 !=j )return j+1;
        }
        return j+1;
    }
}