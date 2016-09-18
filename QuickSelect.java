public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if(nums==null||nums.length == 0){
            return;
        }
        int n = nums.length;
        //Obtain the median
        int mid = quickSelect(nums, 0, n-1, (n-1)/2);
        //Three way partition
        int[] tmp = new int[n];
        int left = 0, right = n-1;
        for(int i=0; i<n; i++){
            if(nums[i] < nums[mid])
                tmp[left++] = nums[i];
            else if(nums[i] > nums[mid])
                tmp[right--] = nums[i];
        }
        for(int i=left; i<=right; i++)
            tmp[i] = nums[mid];
        //wiggle sort
        int l = (n-1)>>1, r = n-1;
        for(int i=0; i<n; i++){
            if((i&1)==0){
                nums[i] = tmp[l--];
            }else{
                nums[i] = tmp[r--];
            }
        }
        
    }
    //Kth smallest
    //Smallest no need to len - mid
    public int quickSelect(int[] nums, int lo, int hi, int k){
        if(lo >= hi){
            return lo;
        }
        int rank = partition(nums, lo, hi);
        if(rank == k){
            return rank;
        }
        if(rank < k){
            return quickSelect(nums, rank + 1, hi, k);
        }
        return quickSelect(nums, lo, rank-1, k);
    }
    
    public int partition(int[] nums, int lo, int hi){
        int pivot = nums[hi];
        int i = lo;
        int j = hi;
        while(i <= j){
            while(i <= j && nums[i] < pivot){
                i++;
            }
            while(i <= j && nums[j] >= pivot){
                j--;
            }
            if(i <= j){
                swap(nums, i, j);
            }
        }
        swap(nums, hi, i);
        return i;
    }
    
    public static void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
