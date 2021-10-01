package com.envamapa.currency.domain

import com.envamapa.currency.entities.Currency
import com.envamapa.currency.entities.mapper.toListOfCurrencies
import io.reactivex.Single
import javax.inject.Inject

class GetCurrenciesUseCaseImpl @Inject constructor(
    private val currencyApi: CurrencyApi
) : GetCurrenciesUseCase {
    override fun invoke(): Single<List<Currency>> =
        currencyApi.getListOfCurrencies()
            .map { currenciesResponse ->
                currenciesResponse.toListOfCurrencies()
            }
}
