package com.java.learning.hibernate.validation.service;

import com.java.learning.hibernate.validation.bean.Color;

import javax.validation.Valid;

public interface ColorService {
    void getColor(@Valid Color color);
}
