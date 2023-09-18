package com.klagan.price.text.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CurrencyDto {

    private String code;
}
