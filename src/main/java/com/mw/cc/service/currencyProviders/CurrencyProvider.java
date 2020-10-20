package com.mw.cc.service.currencyProviders;

import java.math.BigDecimal;
import java.util.Map;

public interface CurrencyProvider {
   void refreshCurrencies();

   Map<String, BigDecimal> getCurrencies();
}
