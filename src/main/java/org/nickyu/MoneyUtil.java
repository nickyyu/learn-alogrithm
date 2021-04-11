package org.nickyu;

/**
 * @ClassName 金额工具类
 * @Description
 * @Author nickyu
 * @DATE 2021/4/6 22:48
 * @Version 1.0
 */
public class MoneyUtil {

    /**
     * 中文数字
     */
    private static String[] chinaDigit = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    /**
     * 节权单位
     */
    private static String[] sectionUnit = {"", "万", "亿", "万亿"};
    /**
     * 权位
     */
    private static String[] chinaUnit = {"", "拾", "佰", "仟"};

    /**
     * 金额单位
     */
    private static String[] moneyUnit = {"元", "角", "分"};

    private static final String ZHENG = "整";


    /**
     * 阿拉伯数字金额转换为中文数字金额
     *
     * @param amount
     * @return
     */
    public static String numberToChina(String amount) {
        StringBuilder result = new StringBuilder();
        int index = amount.indexOf(".");
        if (index == -1) {
            result.append(numberToChina(Integer.valueOf(amount)));
            result.append(moneyUnit[0]).append(ZHENG);
            return result.toString();
        }
        result.append(numberToChina(Integer.valueOf(amount.substring(0, index)))).append(moneyUnit[0]);
        String smallStr = amount.substring(index + 1);
        if (StringUtil.isBlank(smallStr)) {
            result.append(ZHENG);
            return result.toString();
        }
        smallStr = rightPadZero1(smallStr, 2);
        int smallNumber;
        if ((smallNumber = Integer.valueOf(smallStr)) == 0) {
            result.append(ZHENG);
            return result.toString();
        }
        return result.append(smallToChina(smallNumber)).toString();
    }

    /**
     * 小数部分数字转换为中文数字
     * @param smallAmount
     * @return
     */
    public static String smallToChina(int smallAmount) {
        StringBuilder sb = new StringBuilder();
        if (smallAmount < 10) {
            sb.append(chinaDigit[smallAmount]).append(moneyUnit[2]);
        } else if (smallAmount % 10 == 0) {
            sb.append(chinaDigit[smallAmount / 10]).append(moneyUnit[1]);
        } else {
            sb.append(chinaDigit[smallAmount / 10]).append(moneyUnit[1]);
            sb.append(chinaDigit[smallAmount % 10]).append(moneyUnit[2]);
        }
        return sb.toString();

    }

    private static String rightPadZero1(String str, int length) {
        int strLength = str.length();
        StringBuilder sb = new StringBuilder(str);
        while (strLength < length) {
            sb.append("0");
            strLength = sb.length();
        }
        return sb.toString();
    }


    /**
     * 阿拉伯数字转中文数字
     *
     * @param number
     * @return
     */
    public static String numberToChina(int number) {
        int unitPos = 0;
        StringBuilder sb = new StringBuilder();
        boolean needZero = false;

        while (number > 0) {
            int section = number % 10000;
            if (needZero) {
                sb.insert(0, chinaDigit[0]);
            }
            StringBuilder sectionStr = new StringBuilder();
            sectionToChina(section, sectionStr);
            sectionStr.append(section != 0 ? sectionUnit[unitPos] : sectionUnit[0]);
            sb.insert(0, sectionStr);
            needZero = section > 0 && section < 1000;
            number = number / 10000;
            unitPos++;
        }
        return sb.toString();
    }


    /**
     * 节内部阿拉伯数字转换为中文
     *
     * @param section
     * @param sb
     */
    private static void sectionToChina(int section, StringBuilder sb) {
        int unitPos = 0;
        boolean zero = true;

        while (section > 0) {
            int v = section % 10;
            if (v == 0) {
                if (!zero) {
                    zero = true;
                    sb.insert(0, chinaDigit[0]);
                }
            } else {
                zero = false;
                sb.insert(0, chinaDigit[v] + chinaUnit[unitPos]);
            }
            unitPos++;
            section = section / 10;
        }
    }

}
