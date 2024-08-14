package org.softuni.mobilele.init;

import org.softuni.mobilele.config.OpenExchangeRateConfig;
import org.softuni.mobilele.model.dto.ExchangeRatesDTO;
import org.softuni.mobilele.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RatesInit implements CommandLineRunner {

    private final OpenExchangeRateConfig openExchangeRateConfig;
    private final RestTemplate restTemplate;
    private final CurrencyService currencyService;

    public RatesInit(OpenExchangeRateConfig openExchangeRateConfig, RestTemplate restTemplate, CurrencyService currencyService) {
        this.openExchangeRateConfig = openExchangeRateConfig;
        this.restTemplate = restTemplate;
        this.currencyService = currencyService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (openExchangeRateConfig.isEnabled()) {
            String openExchangeRateURLTemplate =
                    new StringBuilder()
                            .append(openExchangeRateConfig.getSchema())
                            .append("://")
                            .append(openExchangeRateConfig.getHost())
                            .append(openExchangeRateConfig.getPath())
                            .append("?app_id={app_id}&symbols={symbols}")
                            .toString();

            Map<String, String> requestParams = Map.of(
                    "app_id", openExchangeRateConfig.getAppID(),
                    "symbols", String.join(",", openExchangeRateConfig.getSymbols())
            );

            ExchangeRatesDTO exchangeRatesDTO = restTemplate
                    .getForObject(openExchangeRateURLTemplate, ExchangeRatesDTO.class, requestParams);

            currencyService.refreshRates(exchangeRatesDTO);
        }
    }
}
