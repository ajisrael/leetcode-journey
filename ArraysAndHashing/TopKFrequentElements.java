package ArraysAndHashing;// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.

import java.util.*;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int num : map.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] answer = new int[k];
        int index = 0;
        for (int num : minHeap) {
            answer[index++] = num;
        }
        
        return answer;
    }
}
