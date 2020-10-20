package com.mw.cc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Value
@AllArgsConstructor
public class Currency {

  String currency;
  String code;
  BigDecimal mid;

}
