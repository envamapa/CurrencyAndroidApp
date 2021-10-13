package com.envamapa.currency.domain

import com.envamapa.currency.entities.Currency
import io.reactivex.Single

interface CurrencyRepository {
    fun getListOfCurrencies(): Single<List<Currency>>
}
