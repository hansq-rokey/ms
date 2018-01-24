package com.fengzhuo.tudou.ms.common;

import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类-字符串处理
 *
 * @author xx
 * @version 2.0
 * @since 2014年1月28日
 */
public final class StringUtil{

    // 每位加权因子  
    private static int power[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     * 构造函数
     */
    private StringUtil() {

    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String isNull(Object o) {
        if (o == null) {
            return "";
        } else {
            String str = "";
            if (o instanceof String) {
                str = (String)o;
            } else {
                str = o.toString();
            }

            return str.trim();
        }
    }
    /**
     * 手机号校验
     *
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        if (isEmpty(phone)) {
            return false;
        }
        String regex = "^1[3|4|5|7|8][0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * 判断邮箱是否有效
     *
     * @param str 邮箱
     * @return 检验结果（true：有效 false：无效）
     */
    public static boolean isMail(String str) {
        String mail = isNull(str);
        Pattern regex = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        Matcher matcher = regex.matcher(mail);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    /**
     * 判断输入的身份证号码是否有效
     *
     * @param str 身份证号码
     * @return 检验结果（true：有效 false：无效）
     */
    public static boolean isCard(String str) {
        String cardId = isNull(str);
        // 身份证正则表达式(15位)
        Pattern isIDCard1 = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
        // 身份证正则表达式(18位)
        Pattern isIDCard2 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
        Matcher matcher1 = isIDCard1.matcher(cardId);
        Matcher matcher2 = isIDCard2.matcher(cardId);
        boolean isMatched = matcher1.matches() || matcher2.matches();
        return isMatched;
    }


    /**
     * 根据身份证Id获取性别
     *
     * @param cardId
     * @return 性别: '男' / '女'
     */
    public static String getSex(String cardId) {
        int sexNum;
        // 15位的最后一位代表性别，18位的第17位代表性别，奇数为男，偶数为女
        if (cardId.length() == 15) {
            sexNum = cardId.charAt(cardId.length() - 1);
        } else {
            sexNum = cardId.charAt(cardId.length() - 2);
        }

        if (sexNum % 2 == 1) {
            return "男";
        } else {
            return "女";
        }
    }

    public static String toString(String separate, int... objs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objs.length; i++) {
            if (i > 0)
                sb.append(separate);
            sb.append(objs[i]);
        }
        return sb.toString();
    }


    public static String toStringArray(Object... list) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (Object o : list) {
            if (index > 0) sb.append(",");
            sb.append(o.toString());
            index++;
        }
        return sb.toString();
    }

    @SuppressWarnings("rawtypes")
    public static String toString(Collection list) {
        return toString(list, ",");
    }

    @SuppressWarnings("rawtypes")
    public static String toString(Collection list, String delim) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (Object o : list) {
            if (index > 0) sb.append(delim);
            sb.append(o.toString());
            index++;
        }
        return sb.toString();
    }

    public static String getRelativePath(File file, File parentFile) {
        return file.getAbsolutePath().replaceFirst("^\\Q" + parentFile.getAbsolutePath() + "\\E", "").replace("\\", "/");
    }
    /**
     * 格式化金额数字为千分位显示；
     *
     * @param str
     * @return
     */
    public static String fmtMicrometer(String str) {
        DecimalFormat df;
        if (str.indexOf(".") > -1) {
            if (str.length() - str.indexOf(".") - 1 == 0) {
                df = new DecimalFormat("###,##0.");
            } else if (str.length() - str.indexOf(".") - 1 == 1) {
                df = new DecimalFormat("###,##0.0");
            } else {
                df = new DecimalFormat("###,##0.00");
            }
        } else {
            df = new DecimalFormat("###,##0");
        }
        double number = Double.parseDouble(str);
        return df.format(number);
    }

    /**
     * 数字验证
     * @param str
     * @return
     */
    public static boolean isDigital(String str) {
        return str == null || "".equals(str) ? false : str.matches("^[0-9]*$");
    }
    /**
     * 将字符数组转为整型数组
     *
     * @param c
     * @return
     * @throws NumberFormatException
     */
    public static int[] converCharToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        for (char temp : c) {
            a[k++] = Integer.parseInt(String.valueOf(temp));
        }
        return a;
    }

    /**
     * 字符转成map类型的
     * 字符串："current=1&mobileType=1&pageSize=10"
     */
    public static Map<String, Object> convertStringToMap(String s) {
        Map<String, Object> m = new HashMap<String, Object>();
        String[] couple = s.split("&");
        for (int i = 0; i < couple.length; i++) {
            String[] single = couple[i].split("=");
            if (single.length < 2) {
                m.put(single[0], "");
                continue;
            }
            m.put(single[0], single[1]);
        }
        return m;
    }
    public static String formatString(String text) {
        return (text == null ? "" : text.trim());
    }

    /**
     * 去除字符串中所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
     * @param s
     * @return
     */
    public static String removeAllBlank(String s){
        String result = "";
        if(null!=s && !"".equals(s)){
            result = s.replaceAll("[　*| *| *|//s*]*", "");
        }
        return result;
    }

    /**
     * 去除字符串中头部和尾部所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
     * @param s
     * @return
     */
    public static String trim(String s){
        String result = "";
        if(null!=s && !"".equals(s)){
            result = s.replaceAll("^[　*| *| *|//s*]*", "").replaceAll("[　*| *| *|//s*]*$", "");
        }
        return result;
    }

    public static String firstCharUpperCase(String s) {
        StringBuffer sb = new StringBuffer(s.substring(0, 1).toUpperCase());
        sb.append(s.substring(1, s.length()));
        return sb.toString();
    }
}
