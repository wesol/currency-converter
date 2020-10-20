package com.mw.cc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Value
@AllArgsConstructor
public class Currencies {

  String table;
  String no;
  String effectiveDate;
  List<Currency> currencies;

}
