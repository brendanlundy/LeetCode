package utility;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrie {

    public static void main(String[] args) {
        SuffixTrie x = new SuffixTrie("hel");
        System.out.println(x.hasSubstring("hp"));
        System.out.println(x.hasSuffix(""));
    }

    private Node root;
    private char stopKey = '$';

    public SuffixTrie(String t) {
        root = new Node();
        t += stopKey;
        int tlength = t.length();
        for (int i = 0; i < tlength; i++) {
            Node current = root;
            for (int j = i; j < tlength; j++) {
                char c = t.charAt(j);
                if (!current.map.containsKey(c))
                    current.map.put(c, new Node());
                current = current.map.get(c);
            }
        }
    }

    private static class Node {
        Map<Character, Node> map;

        Node() {
            map = new HashMap<Character, Node>();
        }
    }

    private Node followPath(String s) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!current.map.containsKey(c))
                return null;
            current = current.map.get(c);
        }
        return current;
    }

    public boolean hasSubstring(String s) {
        return followPath(s) != null;
    }

    public boolean hasSuffix(String s) {
        return followPath(s).map.containsKey(stopKey);
    }
}
