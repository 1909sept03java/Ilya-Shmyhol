package one;

public class Sort {
	public static void main(String[] args) {
		int num[] ={1,0,5,6,3,2,3,7,9,8,4};
		
		BSort(num);
	}
	public static int[] BSort(int[] nums) {
		for (int i=0;i<nums.length-1;i++) {
			for (int f = 0; f < nums.length-i-1; f++) {
				if (nums[f] > nums[f+1]) {
					int temp = nums[f];
					nums[f] = nums[f+1];
					nums[f+1] = temp;
				}
			}
		}
		PrintSort(nums);
		return nums;
	}
	
	public static void PrintSort(int nums[]) {
		for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]);
		}
	}

}
