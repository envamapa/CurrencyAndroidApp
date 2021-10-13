package com.envamapa.currency.data

import com.envamapa.currency.domain.CurrencyRepository
import com.envamapa.currency.entities.Currency
import io.reactivex.Single

class CurrencyRepositoryImpl : CurrencyRepository {
    override fun getListOfCurrencies(): Single<List<Currency>> {
        TODO("Not yet implemented")
    }
}
