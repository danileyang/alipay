package ddalipay

import com.daniel.DDAlipayClient

class AlipayPayController implements BaseExceptionHandler {

    /**
     * 回调
     */
    def callBack() {
        DDAlipayClient ddAlipayClient = new DDAlipayClient("serverUrl", "APPID", "PRIVATE_KEY", "JSON", "utf-8", "PUBLIC_KEY", "RSA", "call_back_url")

        Map<String, String> map = params
        map.remove('action')
        map.remove('controller')
        Boolean verify = ddAlipayClient.verify(map, "RSA", "PARNTERN", "PUBLIC_KEY", "UTF-8")
        if (verify) {
            //TODO:
        } else {
            //TODO:
        }
    }

}
