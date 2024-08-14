package org.softuni.mobilele.model.dto;

//{
//        "disclaimer": "Usage subject to terms: https://openexchangerates.org/terms",
//        "license": "https://openexchangerates.org/license",
//        "timestamp": 1723464000,
//        "base": "USD",
//        "rates": {
//        "EUR": 0.915254,
//        "USD": 1
//        }
//        }

import java.math.BigDecimal;
import java.util.Map;

public record ExchangeRatesDTO(
        String base,
        Map<String, BigDecimal> rates) {

}
