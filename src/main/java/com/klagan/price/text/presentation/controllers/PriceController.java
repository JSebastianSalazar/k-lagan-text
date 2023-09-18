package com.klagan.price.text.presentation.controllers;


import com.klagan.price.text.application.service.PriceService;
import com.klagan.price.text.presentation.dto.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping()
    public Mono<ResponseEntity<PriceDto>> getPrice(
            @RequestParam(name = "brandId") Long brandId,
            @RequestParam(name = "productId") Long productId,
            @RequestParam(name = "applicationDate") LocalDateTime applicationDate,
            @RequestParam(name = "currency") String currency) {

        return priceService.getPrice(brandId, productId, applicationDate, currency)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
