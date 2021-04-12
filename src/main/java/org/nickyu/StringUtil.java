package org.nickyu;

/**
 * @ClassName
 * @Description
 * @Author nickyu
 * @DATE 2021/4/11 17:28
 * @Version 1.0
 */
public class StringUtil {

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }


    /**
     * 字符串匹配（BF算法）
     *
     * @param source 主串
     * @param subStr 字串
     * @return
     */
    public static int indexWithBF(String source, String subStr) {
        char[] sourceChars = source.toCharArray();
        char[] subChars = subStr.toCharArray();
        int sourceLength = sourceChars.length;
        int subLength = subChars.length;
        if (sourceLength < subLength) {
            return -1;
        }
        for (int i = 0; i <= sourceLength - subLength; i++) {
            int j = 0;
            for (; j < subLength; j++) {
                if (sourceChars[i + j] != subChars[j]) {
                    break;
                }
            }
            if (j == subLength) {
                return i;
            }
        }
        return -1;
    }


}
