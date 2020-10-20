package com.mw.cc.service.currencyProviders;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Service
public class CurrencyProviderNbp implements CurrencyProvider {

  private final RestTemplate restController;

  private final List<Object> currencies;

  @Value("${nbp.currency.url}")
  private String url;

  public CurrencyProviderNbp(RestTemplate restController, List<Object> currencies) {
    this.restController = restController;

    //todo do object for response
    //todo do objects for element of the list

    Object[] forObject = restController.getForObject(url, Object[].class); //todo - wrapper and to map

    this.currencies = currencies;
  }

  @Override
  public Map<String, BigDecimal> getCurrencies() {
    return null;
  }
}
