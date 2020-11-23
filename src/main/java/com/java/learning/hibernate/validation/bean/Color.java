package com.java.learning.hibernate.validation.bean;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class Color {
    @NotNull(message="colorName empty~~")
    private String colorName;
    @Max(10)
    @Min(1)
    private Integer colorNum;

    @Valid
    private List<RedColor> redColorList;
}
