package com.cwy.utils.commonUtil;

/**
 * @author siawase
 * @date 2020-06-04 01:52
 */
public class PatternExpUtil {
    public static final String Number = "^\\d+$";//数字

    public final static String TellIdExpirationPattern = "[a-zA-Z0-9_]{6,32}";

    public final static String TellIdLoginExpirationPattern = "[a-zA-Z0-9_.]{5,32}";// 只有登录时校验用

    public final static String PassExpirationPattern = "^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{6,32}$"; //6－10位字符，必须同时包含数字，小写字母，大写字母。

    public final static String CsTelnoExpirationPattern="[0-9\\-]+";   //客服电话   数字、横线

    public final static String PhoneExpirationPattern="^(1[3|4|5|6|7|8|9])\\d{9}$";   //手机号

    public final static String TelExpirationPattern="(^((13[0-9])|(14[5-9])|(15[0-3,5-9])|(17[0-8])|(18[0-9])|(166)|(19[8,9]))\\d{8}$)|^((\\(\\d{3,4}\\)|\\d{3,4}-|\\s)?\\d{7,8}$)";//手机号+固话//TODO

    public final static String OperatorNoExpirationPattern="^[a-zA-Z\\d]{1,32}$";   //操作员账号

    public final static String cardExpirationPattern = "(^$)|(^(\\d){4}$)";
    public final static String cardSequenceNoPattern = "(^$)|(^(\\d){3}$)";
    public final static String cardPwdPattern = "(^$)|(^(\\d){16}$)";
    public final static String NullOrLength_16_Pattern = "(^$)|(^(\\d){16}$)";
    public final static String NullOrLength_18_Pattern = "(^$)|(^(\\d){18}$)";
    public final static String NullOrLength_20_Pattern = "(^$)|(^(\\d){20}$)";
    public final static String NullOrLength_1To32_Pattern = "(^$)|(^(\\d){1,32}$)";
    public final static String NullOrLength_1To160_Pattern = "(^$)|(^(\\d){1,160}$)";
    public final static String numberPatternWithPoint = "^\\d+(\\.\\d{1,4})?$|^0$"; //最多四位小数
    public final static String businessTime = "^([01][0-9]|2[0-3]):([0-5][0-9])$";//验证营业时间
    public final static String amtPatternWithPoint = "^[1-9]{1}\\d*(.\\d{1,2})?$|^0.\\d{1,2}$|0$"; //金额最多两位小数
    public final static String smsCodeExpirationPattern = "^[0-9a-zA-Z]{4}$"; //验证码
    public final static String NewEmail = "^[a-zA-Z0-9_\\-.]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";//"邮箱")
    public final static String orgCode = "^[a-zA-Z0-9]{8}-[a-zA-Z0-9]$"; //组织机构代码
    public final static String DoubleByte = "[^x00-xff]";               //"匹配双字节字符")
    public final static String IdTypePattern = "(0[1|2|3|4|5|6|9])"; //证件类型匹配
    public final static String SettleTermPattern = "(1|2)"; //结算周期匹配
    public final static String unionSwithPattern = "(0|1)"; //银联二维码交易对接引力波开关

    public final static String NsposMemberType = "(^$)|(3)|(5)";//空或3\5匹配
    public final static String AdvanceStat = "(^$)|(0)|(1)";//空或0\1匹配
    //日期可以为空
    public final static String DateP03 = "^((?:(?!0000)[0-9]{4}(?:(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])(?:29|30)|(?:0[13578]|1[02])31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)0229)){0,1}$";
    public final static String SignType = "(1|2|3)";//1\2\3匹配

    public final static String CategoriesSettleTerm = "^$|(0[1|2|3|4|5|6])";  // 沉淀资金收益结算周期
    public final static String CategoriesRate = "^[1-9]{1}\\d*(.\\d{1,2})?$|^0.\\d{0,2}$|0$"; // 沉淀资金收益利率最多两位小数

    public static final String StringP01 = "^\\(('\\w+')(,'\\w+')*\\)$";
    public static final String StringP02 = "('\\w+')(,'\\w+')*";
    public static final String Chinese = "[一-龥]+";
    public static final String Email = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    public static final String PersonID = "^\\d{15}|\\d{17}(\\d|x)$";
    public static final String IDCARD = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
    public static final String AmtP01 = "^(0|[1-9][0-9]*)[\\.][0-9]{2}$";
    public static final String AmtP02 = "(^[1-9][0-9]*$)|(^[0-9]$)";
    public static final String TELEPHONE = "^1\\d{10}$";
    public static final String IP = "\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b";
    public static final String English = "^[a-zA-Z]+$";
    public static final String DateP01 = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
    public static final String DateP02 = "^(?:(?!0000)[0-9]{4}(?:(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])(?:29|30)|(?:0[13578]|1[02])31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)0229)$";
    public static final String cardTypePattern = "(C|D|S|P){1}$";
}
