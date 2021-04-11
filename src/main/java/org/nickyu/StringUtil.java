package org.nickyu;

/**
 * @ClassName
 * @Description
 * @Author nickyu
 * @DATE 2021/4/11 17:28
 * @Version 1.0
 */
public class StringUtil {

    public static boolean isBlank(String str){
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

    public static boolean isEmpty(String str){
        return str == null || "".equals(str);
    }


}
