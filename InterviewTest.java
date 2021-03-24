// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8

        char[] str = S.toCharArray();

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for(int i=0; i < str.length; i++){
            if(frequencyMap.containsKey(str[i])){
                frequencyMap.put(str[i], frequencyMap.get(str[i]) + 1);
            } else {
                frequencyMap.put(str[i], 1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (Map.Entry<Character, Integer> mapEntry : frequencyMap.entrySet()) {
            priorityQueue.add(mapEntry.getValue());
        }

        int deleteCount = 0;
        while (!priorityQueue.isEmpty()) {
            int frequency = priorityQueue.peek();
            priorityQueue.remove();

            if (priorityQueue.isEmpty()) {
                return deleteCount;
            }

            if (frequency == priorityQueue.peek()) {
                if (frequency > 1) {
                    priorityQueue.add(frequency - 1);
                }
                deleteCount++;
            }
        }

        return deleteCount;
    }
}
