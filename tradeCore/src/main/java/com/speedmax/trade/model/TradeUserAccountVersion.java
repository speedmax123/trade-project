package com.speedmax.trade.model;

public class TradeUserAccountVersion {
  private Long id;
  private String first_name;
  private String last_name;
  private Double amount_avaliable;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public Double getAmount_avaliable() {
    return amount_avaliable;
  }

  public void setAmount_avaliable(Double amount_avaliable) {
    this.amount_avaliable = amount_avaliable;
  }
}
