package com.github.hcsp.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    /**
     * hashmap不能存储相同的键，使用put方法时，若指定的键(key)在集合中存在，
     * 则返回值为集合中键对应的值（该值为替换前的值），并把指定键所对应的值，替换成指定的新值。
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
     * Map.getOrDefault(Object key, V defaultValue)方法的作用是：
     *   当Map集合中有这个key时，就使用这个key对应的值；
     *   如果没有就使用默认值defaultValue。
     */

    /**
     * 我到底包含哪些字符？
     *
     * @return 包含的所有字符集合
     */
    public Set<Character> chars() {
        //return charCount.keySet();
        return new HashMap<>(charCount).keySet();
    }

    // 我和另外一个CharCount有多少个公共字符？ 例如，aabbcc和abcdef有3个公共字符: a/b/c，因此返回3
    public int howManyCharsInCommon(CharCount anotherCharCount) {
        Set<Character> myChars = chars();
        Set<Character> theirChars = anotherCharCount.chars();

        theirChars.retainAll(myChars);
        return theirChars.size();
    }
}
