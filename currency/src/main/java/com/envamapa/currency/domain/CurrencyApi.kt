package com.envamapa.currency.domain

import com.envamapa.currency.data.api.entities.CurrenciesResponse
import io.reactivex.Single

interface CurrencyApi {
    fun getListOfCurrencies(): Single<CurrenciesResponse>
}
