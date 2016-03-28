package misc;

import java.util.*;

public class StringPermutations {
    void permute(Map<Character, Integer> input, StringBuffer current) {
        //System.out.println("input: " + input);
        if(input.isEmpty()) {
            System.out.println(current);
        } else {
            List<Character> candidates = generateCandidates(input);
            //System.out.println("candidates: " + candidates);
            for(char c : candidates) {
                current.append(c);
                //System.out.println("current : " + current);
                int cur = input.get(c);
                if(cur - 1 == 0) {
                    input.remove(c);
                } else {
                    input.put(c, cur - 1);
                }
                permute(input, current);
                input.put(c, cur);
                current.deleteCharAt(current.length() -1);
            }
        }
    }

    List<Character> generateCandidates(Map<Character, Integer> input) {
        List<Character> candidates = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : input.entrySet()) {
            int count = entry.getValue();
            while(count-- > 0) {
                candidates.add(entry.getKey());
            }
        }
        return candidates;
    }

    public static void main(String[] args) {
        StringPermutations perm = new StringPermutations();
        String str = "aabc";
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i =0; i< str.length(); i++) {
            char c = str.charAt(i);
            if(charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        perm.permute(charMap, new StringBuffer());
    }
}
