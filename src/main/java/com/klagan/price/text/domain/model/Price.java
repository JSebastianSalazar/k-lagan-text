package com.klagan.price.text.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("PRICES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    @Id
    private Long id;

    @Column("brand_id")
    private Long brandId;

    @Column("start_date")
    private LocalDateTime startDate;

    @Column("end_date")
    private LocalDateTime endDate;

    @Column("price_list")
    private Integer priceList;

    @Column("product_id")
    private Long productId;

    @Column("priority")
    private Integer priority;

    @Column("price")
    private BigDecimal price;

    @Column("curr")
    private String curr;
}
