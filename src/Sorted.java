public class Sorted {
    public static void main(String[] args) {
        int[] nums = {1, 9, 6, 8, 5, 4, 0};

        boolean isSorted = true;

        for (int i = 0; i < nums.length -1 ; i++) {
            if (nums[i] > nums[i + 1]) {
                isSorted = false;
                break;
            }
        }
        System.out.println(isSorted);
    }
}