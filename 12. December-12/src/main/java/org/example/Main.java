package org.example;

import java.util.Arrays;

public class Main {
    static void main() {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] words2 = {
                "eat", "tea", "ate",
                "tan", "nat",
                "bat", "tab",
                "listen", "silent", "enlist",
                "evil", "vile", "live",
                "dusty", "study",
                "inch", "chin",
                "brag", "grab",
                "loop",
                "state", "taste", "teats"
        };
        IO.println(Arrays.deepToString(Solution.groupWords(words)));
//        IO.println(Arrays.deepToString(Solution.groupWords(words2)));
    }
}
