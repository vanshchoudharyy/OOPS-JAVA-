public class SecondLargest {
    public static void main(String[] args) {
        int[] nums = {7, 7, 2, 2, 10, 10, 10};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }
            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println("Second Largest: " + secondLargest);
        }
    }
}
