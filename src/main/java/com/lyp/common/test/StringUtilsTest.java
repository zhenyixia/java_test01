package com.lyp.common.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testStrip() {
        String str = " abcde fgh ";
        System.out.println(StringUtils.strip(str)); //abcde fgh
        String newStr = StringUtils.strip(str, " ab");
        System.out.println(newStr); //cde fgh

        newStr = StringUtils.strip(str, "ab");
        System.out.println(newStr); // abcde fgh 不变

        //总上，只能剥离，字符串左右两侧的字符。默认剥离空字符串。
    }

    @Test
    public void testStripAll() {
        // 针对的是字符数组

        //总上，只能剥离，字符串左右两侧的字符。默认剥离空字符串。
    }

    @Test
    public void testChop() {
        String str = " /\\?*<>:abcde fgh ";
        System.out.println(StringUtils.chop(str)); //abcde fgh
    }
}
