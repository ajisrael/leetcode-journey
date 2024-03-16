package ArraysAndHashing;

import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int maxSequenceLength = 1;
        int currentSequenceLength = 1;

        for (int i = 0; i < list.size()-1; i++){
            if (list.get(i) + 1 == list.get(i+1)){
                currentSequenceLength++;
                if (maxSequenceLength < currentSequenceLength) {
                    maxSequenceLength = currentSequenceLength;
                }
            } else if (maxSequenceLength > list.size()-i) {
                break;
            } else {
                currentSequenceLength = 1;
            }
        }

        return maxSequenceLength;
    }
}
