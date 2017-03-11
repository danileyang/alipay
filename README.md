最简单的alipay支付宝APP支付JAVA SDK
#使用ddalipay快速接入支付宝支付
##关于ddalipay
**ddalipay**，是对支付宝JAVA SDK的进一步封装，旨在提供最简单易用的SDK。目前支持支付宝**RSA**及**RSA2**两种签名方式。值得注意的是，此两种签名方式对应的支付宝公钥不同，请使用者进行正确的配置(目前支付宝在其开放平台中可以查看两种配置对应的公钥，老用户请注意不要在商户平台中查看，商户平台只能查看RSA)。

##如何使用
####gradle：
    compile 'com.github.daniel:ddalipay:0.1
####maven:
	<dependency>
            <groupId>com.github.daniel</groupId>
            <artifactId>ddalipay</artifactId>
            <version>0.1</version>
     </dependency>
     
##使用示例：


      AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("title");
        model.setSubject("subject");
        model.setOutTradeNo("tradeId");
        model.setTimeoutExpress("365d");
        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAY");
        
        
        DDAlipayClient ddAlipayClient = new DDAlipayClient(AlipayConfig.serverUrl,AlipayConfig.appId,AlipayConfig.privateKey,
                AlipayConfig.format,AlipayConfig.charset,AlipayConfig.publicKey,AlipayConfig.signType,AlipayConfig.callbackUrl);

        BaseResult<String> orderInfoResult = ddAlipayClient.buildOrderString(model);

        if (orderInfoResult.success){
            return orderInfoResult.result
        }else {
            //TODO:错误处理
        }