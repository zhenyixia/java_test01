package com.lyp.basicAPI;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

public class StringTest {

  public static byte[] stringToBytes(String charset, String string) throws CharacterCodingException {
    Charset charset1 = Charset.forName(charset);
//    CharsetEncoder charsetEncoder = charset1.newEncoder();
//    ByteBuffer encode = charsetEncoder.encode(CharBuffer.wrap(string));

    //与上面注释等效，不了解区别是什么
    ByteBuffer encode = charset1.encode(CharBuffer.wrap(string));
    byte[] bytes = new byte[encode.limit()];
    encode.get(bytes);
    return bytes;
  }

  public static String bytesToString(String charset, byte[] bytes) throws CharacterCodingException {
    Charset charset1 = Charset.forName(charset);
//    CharsetDecoder charsetDecoder = charset1.newDecoder();
//    CharBuffer decode = charsetDecoder.decode(ByteBuffer.wrap(bytes));

    //与上面注释等效，不了解区别是什么
    CharBuffer decode = charset1.decode(ByteBuffer.wrap(bytes));
    return decode.toString();
  }

  public static void main(String[] args) throws CharacterCodingException {
    byte[] abcdefghijklmns = stringToBytes("utf-8", "abcdefghijklmn");
    System.out.println(Arrays.toString(abcdefghijklmns));
    String s = bytesToString("utf-8", abcdefghijklmns);
    System.out.println(s);
  }


}
