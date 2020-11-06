package com.github.hcsp.collection;

import java.util.HashMap;
import java.util.HashSet;
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
    public Set<Character> chars() {
//        保存到1个新的HashSet就不会有问题了
        return new HashSet<>(charCount.keySet());

//        return charCount.keySet();
//        HashMap<Character, Integer> temp = new HashMap<>();
//        try {
//            BeanUtils.copyProperties( temp,charCount);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return temp.keySet();

//        HashSet<Character> sb = new HashSet<>();
//        try {
//            BeanUtils.copyProperties(charCount.keySet(), sb);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return sb;
    }

    // 我和另外一个CharCount有多少个公共字符？ 例如，aabbcc和abcdef有3个公共字符: a/b/c，因此返回3
    public int howManyCharsInCommon(CharCount anotherCharCount) {
        Set<Character> myChars = chars();
        Set<Character> theirChars = anotherCharCount.chars();

        theirChars.retainAll(myChars);
//        直接操作Map的keySet会改变原有Map

        return theirChars.size();
    }
}
