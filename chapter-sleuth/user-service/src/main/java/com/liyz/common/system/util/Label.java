package com.liyz.common.system.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 用在Entity上，根据此值生成DTO注释和页面Label
 *
 * Package : com.yixin.common.system.util
 *
 * @author YixinCapital -- wujt
 *		   2016年9月9日 上午11:22:00
 *
 */
@Documented
@Target(FIELD)
@Retention(RUNTIME)
public @interface Label {
    /**
     * (Optional) The Label name. Defaults to the unqualified
     * name of the column. This name is used to refer to the
     * frontpage.
     */
    String name() default "";
}
