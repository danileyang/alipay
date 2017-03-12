package com.daniel;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.daniel.base.BaseResult;

/**
 * Created by daniel on 17/3/11.
 */
public class DDAlipayClient {

    private String serverUrl;
    private String appId;
    private String privateKey;
    private String prodCode;
    private String format;
    private String sign_type;
    private String encryptType;
    private String encryptKey;
    private String alipayPublicKey;
    private String charset;
    private String callBackUrl;

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    AlipayClient alipayClient;

    public DDAlipayClient(String serverUrl, String appId, String privateKey, String format, String charset, String alipayPulicKey, String signType, String callBackUrl) {
        this.serverUrl = serverUrl;
        this.appId = appId;
        this.privateKey = privateKey;
        this.format = format;
        this.charset = charset;
        this.alipayPublicKey = alipayPulicKey;
        this.sign_type = signType;
        //"https://openapi.alipay.com/gateway.do", AlipayConfig.ALIPAY_APP_ID, AlipayConfig.PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2"
        alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, "json", charset, alipayPulicKey, signType);
    }

    /*
        model.setBody("title");
        model.setSubject("subject");
        model.setOutTradeNo("tradeId");
        model.setTimeoutExpress("365d");
        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl("http://yourdomain/api/1.0/trade/pay/back.json");//TODO:回调地址
     */
    BaseResult<String> buildOrderString(AlipayTradeAppPayModel model) {

        //实例化客户端
        AlipayClient alipayClient = this.alipayClient;
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
//        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
//        model.setBody("title");
//        model.setSubject("subject");
//        model.setOutTradeNo("tradeId");
//        model.setTimeoutExpress("365d");
//        model.setTotalAmount("0.01");
//        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl(callBackUrl);//TODO:回调地址

        //这里和普通的接口调用不同，使用的是sdkExecute
        try {
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            return new BaseResult<String>(response.getBody());
        } catch (AlipayApiException e) {
            //TODO:LOGGER

            return BaseResult.failure(10001, "调用支付宝失败,exception:" + e.getErrMsg());
        }
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public AlipayClient getAlipayClient() {
        return alipayClient;
    }

    public void setAlipayClient(AlipayClient alipayClient) {
        this.alipayClient = alipayClient;
    }
}
