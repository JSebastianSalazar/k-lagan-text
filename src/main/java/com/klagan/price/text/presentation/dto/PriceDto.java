package com.klagan.price.text.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {

    @Id
    private Long id;

    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private Long productId;

    private Integer priority;

    private BigDecimal price;
    
    private String curr;
}
