package com.envamapa.currency.domain

import com.envamapa.currency.entities.Currency
import com.envamapa.currency.entities.mapper.toListOfCurrencies
import com.envamapa.currency.utils.CurrencyGenerator
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Test

class GetCurrenciesUseCaseImplTest {

    // given a currency api
    private val currencyApi: CurrencyApi = mock()

    // given a get currencies use case 
    private val getCurrenciesUseCase =
        GetCurrenciesUseCaseImpl(currencyApi)

    // given a test observer 
    private val testObserver = TestObserver<List<Currency>>()

    @Test
    fun `when requesting the currencies from the api, then a list of currencies is returned`() {
        // given a list of currencies from api 
        currencyApi.apply {
            whenever(getListOfCurrencies())
                .thenReturn(Single.just(CurrencyGenerator.getListOfCurrenciesApiResponse()))
        }

        // and a expected list of currencies 
        val expectedResult = CurrencyGenerator.getListOfCurrenciesApiResponse()
            .toListOfCurrencies()

        // when executing the use case 
        getCurrenciesUseCase().subscribe(testObserver)

        // then we get a list of currencies 
        testObserver.assertValue(expectedResult)
    }
}
