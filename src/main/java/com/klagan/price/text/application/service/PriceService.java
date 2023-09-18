package com.klagan.price.text.application.service;


import com.klagan.price.text.domain.model.Price;
import com.klagan.price.text.infrastructure.persistence.PriceRepository;
import com.klagan.price.text.presentation.dto.PriceDto;
import com.klagan.price.text.presentation.mappers.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService {

        private final PriceRepository priceRepository;

        public PriceService(PriceRepository priceRepository) {
            this.priceRepository = priceRepository;
        }

    public Mono<PriceDto> getPrice(Long brandId, Long productId, LocalDateTime applicationDate, String currency) {
        validateParameters(brandId, productId, applicationDate, currency);

        return priceRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterAndCurr(
                        brandId, productId, applicationDate,  applicationDate, currency)
                .collectList()
                .flatMap(this::findHighestPriorityPrice)
                .map(price -> entityToDto(price));
    }

    private Mono<Price> findHighestPriorityPrice(List<Price> prices) {
        return Flux.fromIterable(prices)
                .reduce((price1, price2) -> price1.getPriority() > price2.getPriority() ? price1 : price2)
                .switchIfEmpty(Mono.empty());
    }

    private void validateParameters(Long brandId, Long productId, LocalDateTime applicationDate, String currency) {
        if (brandId == null || productId == null || applicationDate == null || currency == null) {
            throw new IllegalArgumentException("Los parámetros no pueden ser nulos.");
        }
    }

    private PriceDto entityToDto(Price price) {
            return PriceDto.builder().build();
    }
}
