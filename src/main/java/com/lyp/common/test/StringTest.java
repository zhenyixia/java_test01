package com.lyp.common.test;

import com.lyp.common.constant.Punctuation;
import org.junit.Test;

public class StringTest {

    /**
     * 下面str1有一个特殊的空格，不能替换消除，
     * 需要归一化才能解决
     */
    @Test
    public void test1() {
        String str1 = "| 　10个看似冷门却十分有趣的心理学现象，你了解么？";
        String whitespaceReg = "[\\s*|" + Punctuation.WHITESPACE_ZH + "*|\\s*]*";
        String newStr = str1.replaceAll("\\s*", "").replaceAll(Punctuation.WHITESPACE_ZH, "");
        System.out.println(newStr);
    }

    @Test
    public void test2() {
//        System.out.println(CharacterSet.);
    }
}
