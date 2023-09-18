package com.klagan.price.text.presentation.mappers;


import com.klagan.price.text.domain.model.Price;
import com.klagan.price.text.presentation.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(source = "sourceField", target = "targetField")
    PriceDto priceToPriceDto(Price price);
}