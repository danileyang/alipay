package ddalipay

import grails.converters.JSON
import org.slf4j.Logger
import org.slf4j.LoggerFactory
/**
 * Created by daniel on 15/11/24.
 */
trait BaseExceptionHandler {

    final static Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    // 输入参数错误
    def handle(IllegalArgumentException e) {
        error(410001, e, "参数错误")
    }

    // 状态不对
    def handle(IllegalStateException e) {
        error(410002, e, "状态错误")
    }

    // 输入参数错误
    def handle(NullPointerException e) {
        error(410003, e, "参数是Null")
    }


    def error(int code, Exception e, String message) {
        logger.error("---> ${this?.class.name} , params : ${params?.toString()}")
        logger.error(e.getMessage(), e)
        def ret = [status: 0, code: code, msg: message]
        render ret as JSON
    }
}
