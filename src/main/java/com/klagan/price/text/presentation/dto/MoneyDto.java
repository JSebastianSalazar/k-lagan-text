package com.klagan.price.text.presentation.dto;


import com.klagan.price.text.domain.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class MoneyDto {
    private BigDecimal amount;
    private Currency currency;
}
