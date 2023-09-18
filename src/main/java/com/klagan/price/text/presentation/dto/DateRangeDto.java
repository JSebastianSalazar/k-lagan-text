package com.klagan.price.text.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class DateRangeDto {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
