// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:

// Input: strs = [""]
// Output: [[""]]
// Example 3:

// Input: strs = ["a"]
// Output: [["a"]]
 

// Constraints:

// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lowercase English letters.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(str);
        }

        return new ArrayList<>(map.values());

    // First solution
    //     List<List<String>> answer = new ArrayList<>();
    //     List<String> firstStringList = new ArrayList<>();
    //     firstStringList.add(strs[0]);
    //     answer.add(firstStringList);

    //     for (int i = 1; i < strs.length; i++) {
    //         boolean anagramFound = false;
    //         for (int j = 0; j < answer.size(); j++) {
    //             if (isAnagram(strs[i], answer.get(j).get(0))) {
    //                 answer.get(j).add(strs[i]);
    //                 anagramFound = true;
    //             }
    //         }

    //         if (!anagramFound) {
    //             List<String> newStringList = new ArrayList<>();
    //             newStringList.add(strs[i]);
    //             answer.add(newStringList);
    //         }
    //     }

    //     return answer;
    // }

    // private boolean isAnagram(String a, String b) {
    //     if (a.length() != b.length()) {
    //         return false;
    //     }

    //     HashMap<Character, Integer> map = new HashMap<>();

    //     for (char c : a.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }

    //     for (char c : b.toCharArray()) {
    //         if (!map.containsKey(c)) {
    //             return false;
    //         }
    //         map.put(c, map.get(c) - 1);
    //         if (map.get(c) == 0) {
    //             map.remove(c);
    //         }
    //     }

    //     return map.isEmpty();
    }
}
