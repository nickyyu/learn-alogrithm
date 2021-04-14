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
     * 查找匹配字符串索引（BF算法）
     *
     * @param source 主串
     * @param subStr 待匹配串
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

    /**
     * 查找匹配字符串索引(KMP算法)
     * @param source 主串
     * @param subStr 待匹配串
     * @return
     */
    public static int indexWithKMP(String source,String subStr){
        char[] sourceChar = source.toCharArray();
        char[] subChar = subStr.toCharArray();
        int subLength = subChar.length;
//        int[] next = getNexts(subChar);
        int[] next = getNexts(subChar,subLength);
        int j = 0;
        for(int i = 0;i<sourceChar.length;i++){
            while (j>0 && sourceChar[i] != subChar[j]){
                j = next[j-1]+1;
            }
            if(sourceChar[i] == subChar[j]){
                j++;
            }

            if(j == subLength){
                return i-subLength+1;
            }
        }
        return -1;

    }

    /**
     * KMP失效函数计算方法
     * @param subChar
     * @return
     */
    public static int[] getNexts(char subChar[]){
        int length = subChar.length;
        int[] next = new int[length];
        next[0] = -1;
        int k = -1;
        for(int i=1;i<length;i++){
            while (k != -1 && subChar[k+1] != subChar[i]){
                k = next[k];
            }
            if(subChar[k+1] == subChar[i]){
                k++;
            }
            next[i] = k;
        }
        return next;
    }


    /**
     *KMP失效函数计算方法（朴素算法）
     * @param ch
     * @param size
     * @return
     */
    public static int[] getNexts(char ch[],int size){
        int[] next = new int[size];
        next[0] = -1;
        for(int i = 1;i<size;i++){
            next[i] = getMaxPatternPrefix(ch,i+1);
        }
        return next;
    }

    /**
     * 获取最大匹配前缀子串结尾字符下标
     * @param ch
     * @param size
     * @return
     */
    public static int getMaxPatternPrefix(char ch[],int size){
        int i = 1,j = -1;
        while(i < size && j < size){
            if(ch[i] == ch[j+1]){
                j++;
            }else {
                j = -1;
            }
            i++;
        }
        return j;
    }


}
