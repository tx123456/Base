package com.tanxin.base.common.base.mvp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author TANXIN
 * @date 2018/7/31
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatePresenter {
    Class<?>[] presenter() default {};
}
