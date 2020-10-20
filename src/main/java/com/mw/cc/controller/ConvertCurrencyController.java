package com.mw.cc.controller;

import com.mw.cc.service.currencyConverters.CurrencyConverter;
import com.mw.cc.service.currencyProviders.CurrencyProvider;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/converters")
@AllArgsConstructor
public class ConvertCurrencyController {

  private final CurrencyConverter currencyConverter;
  private final CurrencyProvider currencyProvider; //todo remove after

  @GetMapping("/currency/{amount}/{originalCurrency}/{targetCurrency}")
  public BigDecimal convert(@PathVariable BigDecimal amount, @PathVariable String originalCurrency, @PathVariable String targetCurrency){

    return currencyConverter.convert(amount, originalCurrency, targetCurrency);
  }

  @GetMapping("/") //todo remove after
  public String test(){

    Map<String, Double> currencies = currencyProvider.getCurrencies();
    return "ok";
  }
}
