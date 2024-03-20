// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

// Example 1:

// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]
// Example 2:

// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]
// Example 3:

// Input: temperatures = [30,60,90]
// Output: [1,1,0]
 

// Constraints:

// 1 <= temperatures.length <= 105
// 30 <= temperatures[i] <= 100

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }

    // Second Solution - Only beat 7%
    // public int[] dailyTemperatures(int[] temperatures) {
    //     Stack<Integer> coldToWarmStack = new Stack<>();
    //     Stack<Integer> coldToWarmStackIndexMap = new Stack<>();
    //     int[] daysTillWarmer = new int[temperatures.length];
    //     boolean noWarmDaysLeft = true;

    //     int tempMaxIndex = temperatures.length-1;
    //     daysTillWarmer[tempMaxIndex] = 0;
    //     coldToWarmStack.push(temperatures[tempMaxIndex]);
    //     coldToWarmStackIndexMap.push(tempMaxIndex);

    //     for (int i = tempMaxIndex - 1; i >= 0; i--) {
    //         int currentTemp = temperatures[i];
    //         boolean endOfStackFound = false;

    //         while (currentTemp >= coldToWarmStack.peek()) {
    //             coldToWarmStack.pop();
    //             coldToWarmStackIndexMap.pop();

    //             if (coldToWarmStack.isEmpty()) {
    //                 daysTillWarmer[i] = 0;
    //                 endOfStackFound = true;
    //                 break;
    //             }
    //         }
            
    //         if (!endOfStackFound) {
    //             daysTillWarmer[i] = coldToWarmStackIndexMap.peek() - i;
    //         }

    //         coldToWarmStack.push(currentTemp);
    //         coldToWarmStackIndexMap.push(i);
    //     }

    //     return daysTillWarmer;
    // }

    // // First Solution - Too slow for large data sets
    // public int[] dailyTemperatures(int[] temperatures) {
    //     int[] daysTillWarmer = new int[temperatures.length];

    //     for (int i = 0; i < temperatures.length; i++) {
    //         int currentTemp = temperatures[i];
    //         daysTillWarmer[i] = 0;
    //         for (int j = i + 1; j < temperatures.length; j++) {
    //             int futureTemp = temperatures[j];

    //             if (futureTemp > currentTemp) {
    //                 daysTillWarmer[i] = j - i;
    //                 break;
    //             }
    //         }
    //     }

    //     return daysTillWarmer;
    // }
}
