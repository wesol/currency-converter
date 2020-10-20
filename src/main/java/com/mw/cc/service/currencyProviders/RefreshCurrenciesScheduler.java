package com.mw.cc.service.currencyProviders;


import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RefreshCurrenciesScheduler {

  private final CurrencyProvider currencyProvider;

  @Scheduled(cron="${refresh.currencies.cron}")
  public void getCurrencyProvider() {
    currencyProvider.refreshCurrencies();
  }
}
