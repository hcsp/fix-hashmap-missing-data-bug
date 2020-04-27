package com.github.hcsp.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
;

public class CharCount {
    /**
     * 保存字符到其出现次数的映射。例如，aabbc这个字符串中，这个Map的值就是
     *
     * <pre>
     * a -> 2
     * b -> 2
     * c -> 1
     * </pre>
     */
    private final Map<Character, Integer> charCount = new HashMap<>();


    public CharCount(String s) {
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (charCount.containsKey(ch)) {
                charCount.put(ch, charCount.get(ch) + 1);
            } else {
                charCount.put(ch, 1);
            }
        }
    }


    public int count(char ch) {
        return charCount.getOrDefault(ch, 0);
    }

    /**
     * 我到底包含哪些字符？
     *
     * @return 包含的所有字符集合
     */
    //第三部看有几个key？？
    public Set<Character> chars() {
        return charCount.keySet();
    }

    public int howManyCharsInCommon(CharCount anotherCharCount) {
        Set<Character> myChars = chars();
        Set<Character> theirChars = new HashSet<>(anotherCharCount.chars());

        theirChars.retainAll(myChars);
        return theirChars.size();
    }

}
