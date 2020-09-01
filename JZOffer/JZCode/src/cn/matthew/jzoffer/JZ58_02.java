package cn.matthew.jzoffer;

/**
 * @ClassName JZ58_02
 * @Description 左旋字符串
 * @Author iematthew
 * @Date 2020/9/01 22:02
 * @Version 1.0
 **/

/*
题目：
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
请定义一个函数实现字符串左旋转操作的功能。
比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

思路：
这道题在考什么？就直接sunstring不就解决了嘛？
 */
public class JZ58_02 {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s, 2));
    }

    public static String reverseLeftWords(String src, int k) {
        if (src == null || k < 1 || k > src.length())
            return null;

        return src.substring(0, k) + src.substring(k);
    }

    //如果不让直接用substring，那把substring手写写一遍
    //  public String substring(int beginIndex) {
    //      if (beginIndex < 0) {
    //          throw new StringIndexOutOfBoundsException(beginIndex);
    //      }
    //      int subLen = value.length - beginIndex;
    //      if (subLen < 0) {
    //          throw new StringIndexOutOfBoundsException(subLen);
    //      }
    //      return (beginIndex == 0) ? this : new String(value, beginIndex, subLen);
    //  }
}
