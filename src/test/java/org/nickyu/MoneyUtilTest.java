package org.nickyu;

import junit.framework.TestCase;
import org.junit.Test;

import static org.nickyu.MoneyUtil.numberToChina;

public class MoneyUtilTest  {

    @Test
    public void testNumberToChina() {
        String numberStr = "11112019.21";//注意不要超过Integer.MAX_VALUE
        System.out.println(numberToChina(numberStr));
    }
}