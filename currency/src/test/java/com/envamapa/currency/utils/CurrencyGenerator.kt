package com.envamapa.currency.utils

import com.envamapa.currency.data.api.entities.CurrenciesResponse

object CurrencyGenerator {

    fun getListOfCurrenciesApiResponse(): CurrenciesResponse =
        Utils.buildResponseModel(
            JSON_FILES.GET_LIST_OF_CURRENCIES.fileName,
            CurrenciesResponse::class.java
        )
}
