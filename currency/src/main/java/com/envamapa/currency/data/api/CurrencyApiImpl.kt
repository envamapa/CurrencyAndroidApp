package com.envamapa.currency.data.api

import com.envamapa.currency.data.api.entities.CurrenciesResponse
import com.envamapa.currency.domain.CurrencyApi
import io.reactivex.Single
import javax.inject.Inject

class CurrencyApiImpl @Inject constructor(
    private val currencyService: CurrencyService
) : CurrencyApi {
    override fun getListOfCurrencies(): Single<CurrenciesResponse> =
        currencyService.getListOfCurrencies()
}