import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        dict.remove(start);
        while(!queue.isEmpty()) {
            String current = queue.poll();
            for(int i =0; i < start.length(); i++) {
                for(char j = 'a'; j <= 'z'; j++) {
                    StringBuilder builder = new StringBuilder(current);
                    if(current.charAt(i) == j) continue;
                    builder.setCharAt(i, j);
                    String neighbor = builder.toString();
                    System.out.println("at level: "+ i + " for character: " + j + " found nighbor: "+ neighbor);
                    if(neighbor.equals(end)) {
                        System.out.println("count updated here and neighbor is: " + neighbor);
                        return i+1;
                    } else {
                        if(dict.contains(neighbor)) {
                            queue.add(neighbor);
                            dict.remove(neighbor);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        Set<String> list = new HashSet<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("length is: " + ladder.ladderLength("a", "c", list));
    }
}
