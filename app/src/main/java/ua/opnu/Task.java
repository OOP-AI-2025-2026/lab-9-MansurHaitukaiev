package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }
    //1
    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String s1 = list.get(i);
            String s2 = list.get(i + 1);
            if (s1.length() <= s2.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    //2
    public void stutter(List<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            list.add(i, list.get(i));
        }
    }

    //3
    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    //4
    public void removeDuplicates(List<String> list) {
        if (list.isEmpty()) return;
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            }
        }
    }

    //5
    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    //6
    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) return true;

        Deque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        boolean isPalindrome = true;

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            stack.push(n);
            queue.add(n);
        }

        for (int i = 0; i < size; i++) {
            int qVal = queue.remove();
            int sVal = stack.pop();

            if (qVal != sVal) {
                isPalindrome = false;
            }
            queue.add(qVal);
        }

        return isPalindrome;
    }

    //7
    public void reorder(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        int count = 0;

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n < 0) {
                stack.push(n);
            } else {
                queue.add(n);
                count++;
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < count; i++) {
            queue.add(queue.remove());
        }
    }

    //8
    public void rearrange(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        int oddCount = 0;

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n % 2 == 0) {
                queue.add(n);
            } else {
                stack.push(n);
                oddCount++;
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        int evenCount = size - oddCount;
        for (int i = 0; i < evenCount; i++) {
            queue.add(queue.remove());
        }

        for (int i = 0; i < oddCount; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    //9
    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    //10
    public void removeEvenLength(Set<String> set) {
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String s = itr.next();
            if (s.length() % 2 == 0) {
                itr.remove();
            }
        }
    }

    //11
    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        return set1.size();
    }

    //12
    public boolean isUnique(Map<String, String> map) {
        Collection<String> values = map.values();
        Set<String> uniqueValues = new HashSet<>(values);

        return uniqueValues.size() == values.size();
    }

    //13
    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                Integer val1 = map1.get(key);
                Integer val2 = map2.get(key);

                if (Objects.equals(val1, val2)) {
                    result.put(key, val1);
                }
            }
        }
        return result;
    }

    //14
    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    //15
    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Map cannot be empty");
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer val : map.values()) {
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        int resultValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (count < minCount) {
                minCount = count;
                resultValue = value;
            } else if (count == minCount) {
                if (value < resultValue) {
                    resultValue = value;
                }
            }
        }

        return resultValue;
    }

    //16
    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> counts = new HashMap<>();
        int maxOcc = 0;

        for (Integer num : list) {
            int count = counts.getOrDefault(num, 0) + 1;
            counts.put(num, count);

            if (count > maxOcc) {
                maxOcc = count;
            }
        }

        return maxOcc;
    }
}