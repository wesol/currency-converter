package com.mw.cc.service.currencyConverters;

import com.mw.cc.service.currencyProviders.CurrencyProvider;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

@Service
@AllArgsConstructor
@Log4j2
@Profile("nbp")
public class CurrencyConverterNbp implements CurrencyConverter {

  private final CurrencyProvider provider;

  @Override
  public BigDecimal convert(BigDecimal amount, String originalCurrency, String targetCurrency) {

    Map<String, BigDecimal> currencies = provider.getCurrencies();
    if (currencies.containsKey(originalCurrency) && currencies.containsKey(targetCurrency)) {
      BigDecimal divide = currencies.get(originalCurrency).divide(currencies.get(targetCurrency), MathContext.DECIMAL32);
      return amount.multiply(divide);
    } else {
      log.info("No data for code: " + originalCurrency + " or: " + targetCurrency);
      return new BigDecimal(-1);
    }
  }
}
