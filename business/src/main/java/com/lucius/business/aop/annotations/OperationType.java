package com.lucius.business.aop.annotations;



import com.lucius.business.aop.enums.OperationCategory;
import com.lucius.business.aop.enums.OperationContent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <br>
 *
 * @author sunzhongshuai
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationType {
    OperationContent value();
    OperationCategory type();
}
