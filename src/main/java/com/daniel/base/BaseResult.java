package com.daniel.base;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isNotBlank;
import static org.apache.commons.lang.StringUtils.trim;

/**
 * Created by daniel on 17/3/11.
 */
public class BaseResult<T> extends Base implements Serializable {

    private static final long serialVersionUID = 9171427473820615287L;

    static Logger logger = LoggerFactory.getLogger(BaseResult.class);

    /**
     * 保留字段，所有正常的返回结构，key都是result
     */
    private static final String DEFAULT_RESULT_SYMBOL = "result";

    private static final String DEFAULT_SUCCESS_SYMBOL = "success";

    private static final String DEFAULT_CODE_SYMBOL = "code";

    private static final String DEFAULT_MESSAGE_SYMBOL = "message";

    private static final String DEFAULT_TYPE_SYMBOL = "type";

    /**
     * 所有信息
     */
    private Map<String, Object> resultMap = Maps.newConcurrentMap();

    public BaseResult() {

    }

    public BaseResult(@Nonnull T result) {
        setResult(result);
        setSuccess(true);
        setCode(0);
        setMessage("操作成功");
    }

    /**
     * 用来存放额外信息，但是key，绝对不能够是"result"
     *
     * @param key   String - Json字符串的key
     * @param value Object - 值
     */
    public BaseResult<T> putExternal(String key, Object value) {
        checkArgument(isNotBlank(key));
        checkArgument(!DEFAULT_RESULT_SYMBOL.equals(trim(key)));
        resultMap.put(key, checkNotNull(value));
        return this;
    }

    public BaseResult<T> setResult(T result) {
        resultMap.put(DEFAULT_RESULT_SYMBOL, checkNotNull(result));
        return this;
    }

    public BaseResult<T> setCode(int code) {
        resultMap.put(DEFAULT_CODE_SYMBOL, checkNotNull(code));
        return this;
    }

    public int getCode() {
        return (int) resultMap.get(DEFAULT_CODE_SYMBOL);
    }

    public String getMessage() {
        return (String) resultMap.get(DEFAULT_MESSAGE_SYMBOL);
    }

    public BaseResult<T> setType(String type) {
        resultMap.put(DEFAULT_TYPE_SYMBOL, checkNotNull(type));
        return this;
    }

    public BaseResult<T> setSuccess(boolean success) {
        resultMap.put(DEFAULT_SUCCESS_SYMBOL, checkNotNull(success));
        return this;
    }

    public boolean isSuccess() {
        return (boolean) resultMap.get(DEFAULT_SUCCESS_SYMBOL);
    }

    public BaseResult<T> setMessage(String message) {
        resultMap.put(DEFAULT_MESSAGE_SYMBOL, checkNotNull(message));
        return this;
    }


    public T getResult() {
        return (T) resultMap.get(DEFAULT_RESULT_SYMBOL);
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public static <T> BaseResult<T> emptyResult() {
        return new BaseResult<T>().setResult(null).setSuccess(true);
    }

    public static <T> BaseResult<T> failure(int code, String message) {
        return new BaseResult<T>().setSuccess(false).setCode(code).setMessage(message);
    }

}