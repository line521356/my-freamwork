package com.lucius.business.validata;

import com.lucius.business.constraint.MyConstraint;
import com.lucius.business.model.House;
import com.lucius.business.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/27
 * @Emial Lucius.li@ixiaoshuidi.com
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HouseService houseService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        houseService.findById(Long.valueOf(value.toString()));
        System.out.println(value);
        return true;
    }

}
