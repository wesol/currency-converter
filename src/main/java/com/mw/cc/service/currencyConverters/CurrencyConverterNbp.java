package com.mw.cc.service.currencyConverters;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConverterNbp implements CurrencyConverter {

  @Override
  public BigDecimal convert(BigDecimal amount, String originalCurrency, String targetCurrency) {
    return null;
  }
}
