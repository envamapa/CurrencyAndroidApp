package com.envamapa.currency.domain

import com.envamapa.currency.entities.Currency
import io.reactivex.Single

interface GetCurrenciesUseCase {
    operator fun invoke(): Single<List<Currency>>
}
