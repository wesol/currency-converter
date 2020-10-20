package com.mw.cc.service.currencyConverters;

import java.math.BigDecimal;

public interface CurrencyConverter {

  BigDecimal convert(BigDecimal amount, String originalCurrency, String targetCurrency);

}
