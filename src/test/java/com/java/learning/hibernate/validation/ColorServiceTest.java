package com.java.learning.hibernate.validation;

import com.java.learning.hibernate.validation.bean.Color;
import com.java.learning.hibernate.validation.service.ColorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ColorServiceTest {
    @Autowired
    private ColorService colorService;
    @Test
    public void testGetColor(){
        Color color= Color.builder().colorNum(0).build();
        colorService.getColor(color);
    }
}
