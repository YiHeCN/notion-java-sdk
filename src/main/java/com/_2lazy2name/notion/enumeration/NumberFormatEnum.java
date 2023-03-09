package com._2lazy2name.notion.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// Disable spell checking for this file
@SuppressWarnings("all")
public enum NumberFormatEnum {
    NUMBER("number"),
    NUMBER_WITH_COMMAS("number_with_commas"),
    PERCENT("percent"),
    DOLLAR("dollar"),
    CANADIAN_DOLLAR("canadian_dollar"),
    EURO("euro"),
    POUND("pound"),
    YEN("yen"),
    RUBLE("ruble"),
    RUPEE("rupee"),
    WON("won"),
    YUAN("yuan"),
    REAL("real"),
    LIRA("lira"),
    RUPIAH("rupiah"),
    FRANC("franc"),
    HONG_KONG_DOLLAR("hong_kong_dollar"),
    NEW_ZEALAND_DOLLAR("new_zealand_dollar"),
    KRONA("krona"),
    NORWEGIAN_KRONE("norwegian_krone"),
    MEXICAN_PESO("mexican_peso"),
    RAND("rand"),
    NEW_TAIWAN_DOLLAR("new_taiwan_dollar"),
    DANISH_KRONE("danish_krone"),
    ZLOTY("zloty"),
    BAHT("baht"),
    FORINT("forint"),
    KORUNA("koruna"),
    SHEKEL("shekel"),
    CHILEAN_PESO("chilean_peso"),
    PHILIPPINE_PESO("philippine_peso"),
    DIRHAM("dirham"),
    COLOMBIAN_PESO("colombian_peso"),
    RIYAL("riyal"),
    RINGGIT("ringgit"),
    LEU("leu"),
    ARGENTINE_PESO("argentine_peso"),
    URUGUAYAN_PESO("uruguayan_peso"),
    SINGAPORE_DOLLAR("singapore_dollar");

    private
    final String format;

    @JsonCreator
    NumberFormatEnum(String format) {
        this.format = format;
    }

    @JsonValue
    @Override
    public String toString() {
        return format;
    }
}
