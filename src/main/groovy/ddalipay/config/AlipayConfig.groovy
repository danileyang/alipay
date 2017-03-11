package ddalipay.config

import java.security.interfaces.RSAPrivateKey

/**
 * Created by daniel on 16/11/24.
 */
class AlipayConfig {

    public static boolean partner_key_loaded = false;

    public static String ALIPAY_APP_ID = ''

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 合作身份者ID，以2088开头由16位纯数字组成的字符串
    public static String partner = "";

    // 支付宝的公钥，无需修改该值
    public
    static String ALIPAY_PUBLIC_KEY = "";

    public static RSAPrivateKey PARTNER_PRIVATE_KEY = null;


    public static String PARTNER_PUBLIC_KEY = ""
    // 商户的私钥
    public
    static String PRIVATE_KEY = "";

    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    // 调试用，创建TXT日志文件夹路径
    public static String log_path = "~/logs";//TODO:

    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String CHARSET = "UTF-8";

    public static String OUT_OF_DATE_TIME = "2d";

    public static String ALIPAY_PAY_INTERFACE = "alipay.trade.app.pay";

    // 签名方式 不需修改
    public static String SIGN_TYPE = "RSA2";


    public static RSAPrivateKey getPARTNER_PRIVATE_KEY() {
        return PARTNER_PRIVATE_KEY;
    }

    public static void setPARTNER_PRIVATE_KEY(RSAPrivateKey PARTNER_PRIVATE_KEY) {
        AlipayConfig.PARTNER_PRIVATE_KEY = PARTNER_PRIVATE_KEY;
    }

    public boolean isPartner_key_loaded() {
        return partner_key_loaded;
    }

    public void setPartner_key_loaded(boolean partner_key_loaded) {
        this.partner_key_loaded = partner_key_loaded;
    }
}
