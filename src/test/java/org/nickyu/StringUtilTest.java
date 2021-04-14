package org.nickyu;

import org.junit.Assert;
import org.junit.Test;


public class StringUtilTest {
    @Test
    public void isBlank() {
    }

    @Test
    public void isNotBlank() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void indexWithBF() {
        String str = "11111111111122222222223sjsjsjskshkskshksksks";
        String subStr = "sks";
        Assert.assertTrue(StringUtil.indexWithBF(str,subStr) != -1);
        subStr = "avsbsham";
        Assert.assertTrue(StringUtil.indexWithBF(str,subStr) == -1);
        subStr = "sksa";
        Assert.assertTrue(StringUtil.indexWithBF(str,subStr) == -1);
    }

    @Test
    public void indexWithKMP() {
        String str = "11111111111122222222223sjsjsjskshkskshksksks";
        String subStr = "sks";
        Assert.assertTrue(StringUtil.indexWithKMP(str,subStr) != -1);
        subStr = "avsbsham";
        Assert.assertTrue(StringUtil.indexWithKMP(str,subStr) == -1);
        subStr = "sksa";
        Assert.assertTrue(StringUtil.indexWithKMP(str,subStr) == -1);
    }


    @Test
    public void getMaxPatternPrefix(){
        String patStr = "sksks";
        char[] chars = patStr.toCharArray();
        int index = StringUtil.getMaxPatternPrefix(chars,chars.length);
        Assert.assertTrue(index == 2);
    }
}
