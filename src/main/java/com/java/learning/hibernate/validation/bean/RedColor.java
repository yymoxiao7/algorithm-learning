package com.java.learning.hibernate.validation.bean;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class RedColor {
    @NotNull(message = "red is empty~~")
    private String red;
}
