package ddalipay.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by daniel on 17/3/11.
 */
public abstract class Base {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new NoNullFieldStringStyle());
    }
}