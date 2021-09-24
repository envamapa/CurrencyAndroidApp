package com.envamapa.currency.data.api

import com.envamapa.currency.data.api.entities.CurrenciesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CurrencyService {
    @GET("/gh/fawazahmed0/currency-api@1/latest/currencies.json")
    fun getListOfCurrencies(): Single<CurrenciesResponse>
}
