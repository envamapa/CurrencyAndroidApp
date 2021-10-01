package com.envamapa.currency.entities.mapper

import com.envamapa.currency.data.api.entities.CurrenciesResponse
import com.envamapa.currency.entities.Currency
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParser

fun CurrenciesResponse.toListOfCurrencies(): List<Currency> {
    val currencies: JsonElement = JsonParser().parse(Gson().toJson(this))
    val obj = currencies.asJsonObject
    return obj.entrySet().map {
        Currency(
            key = it.key,
            name = it.value.asString
        )
    }
}
