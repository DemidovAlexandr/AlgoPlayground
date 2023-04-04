import java.util.ArrayList;

public class RangeOfOnes {

    int max = 0;
    int current = 0;
    ArrayList<Integer> zeroes = new ArrayList<>();
    ArrayList<Integer> zeroesDiff = new ArrayList<>();

    // arr {0, 1, 1, 0, 0, 1, 1, 1, 0, 1}
    // zeroes {0, 3, 4, 8}
    // zeroesDiff {2, 0, 3, 1}
    // sums -> max {2, 3, 4} -> 4

    // int[] arr = {1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1};
    // {4, 8, 9}
    // {4, 3, 0, 1}


    //{0, 0, 1, 1, 1, 0, 1, 1, 0, 0
    //{0, 1, 5, 8, 9}
    //{0, 3, 2, 0}
    public int findRange(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
           if (arr[i] == 0) {
               zeroes.add(i);
           }
        }
        if (zeroes.get(0) != 0) {
            zeroesDiff.add(zeroes.get(0));
        }

        for (int i = 0; i < (zeroes.size() - 1); i++) {
            current = zeroes.get(i + 1) - zeroes.get(i) - 1;
            zeroesDiff.add(current);
        }

        if (zeroes.get(zeroes.size() - 1) < arr.length) {
            zeroesDiff.add(arr.length - 1 - zeroes.get(zeroes.size() - 1));
        }

        for (int i = 0; i < (zeroesDiff.size() - 1); i++) {
            int sum = zeroesDiff.get(i) + zeroesDiff.get(i + 1);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int windowStart = 0;
        int maxFlipOperations = 1;
        int maxConsecutive1s = 0;

        for (int windowEnd = 0; windowEnd < nums.length; ++windowEnd) {
            if (nums[windowEnd] == 1) {
                ++maxConsecutive1s;
            }

            if (windowEnd - windowStart + 1 - maxConsecutive1s > maxFlipOperations) {
                if (nums[windowStart] == 1) {
                    --maxConsecutive1s;
                }

                ++windowStart;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart);
        }

        return maxLength;
    }
}
