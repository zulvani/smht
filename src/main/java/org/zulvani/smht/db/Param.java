package org.zulvani.smht.db;

public class Param {

  public final static String OPERATOR_LIKE = "like";
  public final static String OPERATOR_EQUAL = "equal";
  
  private String name;
  private Object value;
  private String operator;

  public Param(){
    operator = OPERATOR_EQUAL;
  }
  
  public Param(String name, Object value){
    this.name = name;
    this.value = value;
    operator = OPERATOR_EQUAL;
  }
  
  public Param(String name, Object value, String operator){
    this.name = name;
    this.value = value;
    this.operator = operator;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }
}