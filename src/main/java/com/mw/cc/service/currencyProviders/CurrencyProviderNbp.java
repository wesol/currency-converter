package com.mw.cc.service.currencyProviders;

import com.mw.cc.dto.Currencies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Service
public class CurrencyProviderNbp implements CurrencyProvider {

  private final RestTemplate restTemplate;

  private final Map<String, BigDecimal> currencies;

  @Value("${nbp.currency.url}")
  private String url;

  public CurrencyProviderNbp(RestTemplate restController) {
    this.restTemplate = restController;

    Currencies currenciesObject = restController.getForObject(url, Currencies.class);
    Map<String, BigDecimal> currenciesMap = new HashMap<>();

    if (currenciesObject != null) {
      currenciesObject.getCurrencies().forEach(currency -> currenciesMap.put(currency.getCode(), currency.getMid()));
    }

    this.currencies = currenciesMap;
  }

  @Override
  public Map<String, BigDecimal> getCurrencies() {
    return currencies;
  }
}
