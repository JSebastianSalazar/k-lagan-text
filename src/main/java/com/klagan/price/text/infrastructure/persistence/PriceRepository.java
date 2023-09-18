package com.klagan.price.text.infrastructure.persistence;


import com.klagan.price.text.domain.model.Price;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends ReactiveCrudRepository<Price, Long> {
    Flux<Price> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterAndCurr(
            Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate, String curr);
}
