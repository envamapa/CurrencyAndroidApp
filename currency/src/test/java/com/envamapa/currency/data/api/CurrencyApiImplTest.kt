package com.envamapa.currency.data.api

import com.envamapa.currency.utils.CurrencyGenerator
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class CurrencyApiImplTest {

    private val currencyService = mock<CurrencyService>()

    private val currencyApi = CurrencyApiImpl(currencyService)

    @Test
    fun `when getting the currencies, a response is received`() {
        // given a currency service
        currencyService.apply {
            whenever(getListOfCurrencies())
                .thenReturn(Single.just(CurrencyGenerator.getListOfCurrenciesApiResponse()))
        }

        // and a expected result
        val expectedResult = CurrencyGenerator.getListOfCurrenciesApiResponse()

        // when getting the list of currencies 
        val result = currencyApi.getListOfCurrencies().test()

        result.assertValue(expectedResult)
    }
}
