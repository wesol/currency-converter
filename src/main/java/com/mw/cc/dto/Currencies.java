package com.mw.cc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class Currencies {

  private String table;
  private String no;
  private String effectiveDate;
  private List<Currency> rates;

}
