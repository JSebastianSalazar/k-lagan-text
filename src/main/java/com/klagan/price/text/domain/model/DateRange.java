package com.klagan.price.text.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;



@Data
@Builder
public class DateRange {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
