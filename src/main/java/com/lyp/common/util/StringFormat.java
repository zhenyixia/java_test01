package com.lyp.common.util;

import java.text.Normalizer;

/**
 * 归一化处理
 */
public class StringFormat {

    public static String normalize(String inputString) {
        return Normalizer.normalize(inputString, Normalizer.Form.NFKC);
    }
}
