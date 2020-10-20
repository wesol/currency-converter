package com.mw.cc.service.currencyProviders;

import com.mw.cc.dto.Currencies;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Service
@Log4j2
@Profile("nbp")
public class CurrencyProviderNbp implements CurrencyProvider {

  private final RestTemplate restTemplate;

  private final Map<String, BigDecimal> currencies;

  private final String url;

  public CurrencyProviderNbp(RestTemplate restTemplate, @Value("${nbp.currency.url}") String url) {

    this.restTemplate = restTemplate;
    this.url = url;

    Map<String, BigDecimal> currenciesMap = new HashMap<>();

    fillCurrenciesMap(currenciesMap);

    this.currencies = currenciesMap;
  }

  private void fillCurrenciesMap(Map<String, BigDecimal> currenciesMap) {

    Currencies[] currenciesArray = null;
    try {
      currenciesArray = restTemplate.getForObject(url, Currencies[].class);
    } catch (RestClientException e) {
      log.error("Problem with api");
    }

    if (currenciesArray != null) {
      currenciesMap.clear();
      for (Currencies currenciesObject : currenciesArray) {
        currenciesObject.getRates().forEach(currency -> currenciesMap.put(currency.getCode(), currency.getMid()));
      }
    }
  }

  @Override
  public Map<String, BigDecimal> getCurrencies() {
    return currencies;
  }
}
