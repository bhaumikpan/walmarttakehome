package com.example.feature_domain.model

import com.google.gson.annotations.SerializedName

/* list of Country as
{
    "capital": "Kabul",
    "code": "AF",
    "currency": {
    "code": "AFN",
    "name": "Afghan afghani",
    "symbol": "؋"
},
    "flag": "https://restcountries.eu/data/afg.svg",
    "language": {
    "code": "ps",
    "name": "Pashto"
},
    "name": "Afghanistan",
    "region": "AS"
},*/
data class Country(
    @SerializedName("capital"  ) var capital  : String?   = null,
    @SerializedName("code"     ) var code     : String?   = null,
    @SerializedName("currency" ) var currency : Currency? = Currency(),
    @SerializedName("flag"     ) var flag     : String?   = null,
    @SerializedName("language" ) var language : Language? = Language(),
    @SerializedName("name"     ) var name     : String?   = null,
    @SerializedName("region"   ) var region   : String?   = null
)

data class Currency (
    @SerializedName("code"   ) var code   : String? = null,
    @SerializedName("name"   ) var name   : String? = null,
    @SerializedName("symbol" ) var symbol : String? = null
)

data class Language (
    @SerializedName("code" ) var code : String? = null,
    @SerializedName("name" ) var name : String? = null
)
