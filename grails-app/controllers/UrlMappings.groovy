class UrlMappings {

    static mappings = {

        //刷新token
        "/api/1.0/pay/alipay"(controller: "alipayPay", action: 'pay')
    }
}
