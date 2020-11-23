package com.java.learning.hibernate.validation;

import com.java.learning.hibernate.validation.bean.Color;
import com.java.learning.hibernate.validation.bean.RedColor;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ValidationTest {
    @Test
    public void test(){
        RedColor redColor=RedColor.builder().red("redColor").build();
        List<RedColor> redColorList=new ArrayList<>();
        redColorList.add(redColor);
        Color color= Color.builder().colorNum(0).redColorList(redColorList).build();

        // 注意该处只验证了Person 为了说明 @Valid 注释的使用
        ValidatorFactory validatorFactory= Validation.byDefaultProvider().configure().buildValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<Color>> violations= validator.validate(color);
        violations.forEach(validatorResult->{
            System.out.println(validatorResult);
        });
    }
}
