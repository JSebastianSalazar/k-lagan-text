package com.klagan.price.text.presentation;


import com.klagan.price.text.presentation.dto.PriceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureWebTestClient
public class PriceControllerTest {


    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetPriceRequest1() {
        // Construye una solicitud GET reactiva para el Test 1
        webTestClient.get()
                .uri("/prices?brandId=1&productId=35455&applicationDate=2020-06-14T10:00:00&currency=EUR")
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> {  assertThat(priceDto.getProductId()).isEqualTo(35455);
                    assertThat(priceDto.getBrandId()).isEqualTo(1);
                    assertThat(priceDto.getStartDate()).isEqualTo(LocalDateTime.of(2020,
                            6, 14, 0, 0, 0));
                    assertThat(priceDto.getEndDate()).isEqualTo(LocalDateTime.of(2020,
                            12, 31, 23, 59, 59));
                    assertThat(priceDto.getPriceList()).isEqualTo(1);
                    assertThat(priceDto.getPriority()).isEqualTo(0);
                    assertThat(priceDto.getPrice()).isEqualByComparingTo(new BigDecimal("35.50"));
                    assertThat(priceDto.getCurr()).isEqualTo("EUR");
                    assertThat(priceDto.getProductId()).isEqualTo(35455);

                });
    }


    @Test
    public void testGetPriceRequest2() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0);

        webTestClient.get()
                .uri("/prices?brandId=1&productId=35455&applicationDate=" + applicationDate + "&currency=EUR")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> {
                    assertThat(priceDto.getProductId()).isEqualTo(35455);
                    assertThat(priceDto.getBrandId()).isEqualTo(1);
                    assertThat(priceDto.getStartDate()).isEqualTo(LocalDateTime.of(2020, 6, 14, 15, 0, 0));
                    assertThat(priceDto.getEndDate()).isEqualTo(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
                    assertThat(priceDto.getPriceList()).isEqualTo(2);
                    assertThat(priceDto.getPriority()).isEqualTo(1);
                    assertThat(priceDto.getPrice()).isEqualByComparingTo(new BigDecimal("25.45"));
                    assertThat(priceDto.getCurr()).isEqualTo("EUR");

                });
    }

    @Test
    public void testGetPriceRequest3() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0, 0);

        webTestClient.get()
                .uri("/prices?brandId=1&productId=35455&applicationDate=" + applicationDate + "&currency=EUR")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> {
                    assertThat(priceDto.getProductId()).isEqualTo(35455);
                    assertThat(priceDto.getBrandId()).isEqualTo(1);
                    assertThat(priceDto.getStartDate()).isEqualTo(LocalDateTime.of(2020, 6, 14, 16, 0, 0));
                    assertThat(priceDto.getEndDate()).isEqualTo(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
                    assertThat(priceDto.getPriceList()).isEqualTo(2);
                    assertThat(priceDto.getPriority()).isEqualTo(1);
                    assertThat(priceDto.getPrice()).isEqualByComparingTo(new BigDecimal("25.45"));
                    assertThat(priceDto.getCurr()).isEqualTo("EUR");
                });
    }


    @Test
    public void testGetPriceRequest4() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0, 0);

        webTestClient.get()
                .uri("/prices?brandId=1&productId=35455&applicationDate=" + applicationDate + "&currency=EUR")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> {
                    assertThat(priceDto.getProductId()).isEqualTo(35455);
                    assertThat(priceDto.getBrandId()).isEqualTo(1);
                    assertThat(priceDto.getStartDate()).isEqualTo(LocalDateTime.of(2020, 6, 15, 0, 0, 0));
                    assertThat(priceDto.getEndDate()).isEqualTo(LocalDateTime.of(2020, 6, 15, 11, 0, 0));
                    assertThat(priceDto.getPriceList()).isEqualTo(3);
                    assertThat(priceDto.getPriority()).isEqualTo(1);
                    assertThat(priceDto.getPrice()).isEqualByComparingTo(new BigDecimal("30.50"));
                    assertThat(priceDto.getCurr()).isEqualTo("EUR");
                });
    }

    @Test
    public void testGetPriceRequest5() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0, 0);

        webTestClient.get()
                .uri("/prices?brandId=1&productId=35455&applicationDate=" + applicationDate + "&currency=EUR")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> {
                    assertThat(priceDto.getProductId()).isEqualTo(35455);
                    assertThat(priceDto.getBrandId()).isEqualTo(1);
                    assertThat(priceDto.getStartDate()).isEqualTo(LocalDateTime.of(2020, 6,
                            15, 16, 0, 0));
                    assertThat(priceDto.getEndDate()).isEqualTo(LocalDateTime.of(2020, 12,
                            31, 23, 59, 59));
                    assertThat(priceDto.getPriceList()).isEqualTo(4);
                    assertThat(priceDto.getPriority()).isEqualTo(1);
                    assertThat(priceDto.getPrice()).isEqualByComparingTo(new BigDecimal("38.95"));
                    assertThat(priceDto.getCurr()).isEqualTo("EUR");
                });
    }
}
