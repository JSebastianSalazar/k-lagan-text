package com.klagan.price.text.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;



@Data
@Builder
public class Money {

    private BigDecimal amount;
    private Currency currency;


}
