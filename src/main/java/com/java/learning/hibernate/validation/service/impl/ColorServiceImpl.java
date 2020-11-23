package com.java.learning.hibernate.validation.service.impl;

import com.java.learning.hibernate.validation.bean.Color;
import com.java.learning.hibernate.validation.service.ColorService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class ColorServiceImpl implements ColorService {
    @Override
    public void getColor(@Valid Color color) {

    }
}
