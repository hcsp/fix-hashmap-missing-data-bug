package com.github.hcsp.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharCountTest {
    @Test
    public void test() {
        CharCount charCount1 = new CharCount("aabbcc");
        CharCount charCount2 = new CharCount("bcd");

        Assertions.assertEquals(2, charCount1.count('a'));
        Assertions.assertEquals(0, charCount1.count('z'));

        // 有两个公共字符：b和c
        Assertions.assertEquals(2, charCount1.howManyCharsInCommon(charCount2));

        Assertions.assertEquals(2, charCount1.count('b'));
        Assertions.assertEquals(2, charCount1.count('c'));

        Assertions.assertEquals(1, charCount2.count('b'));
        Assertions.assertEquals(1, charCount2.count('c'));
        Assertions.assertEquals(1, charCount2.count('d'));

        Assertions.assertEquals(3, charCount1.chars().size());
        Assertions.assertEquals(3, charCount2.chars().size());
    }
}
