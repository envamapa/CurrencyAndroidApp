package com.envamapa.currency.utils

import com.google.gson.Gson
import org.junit.Assert
import java.lang.reflect.Type

object Utils {

    fun <T> buildResponseModel(
        fileName: String,
        typeOf: Type
    ): T {
        Assert.assertNotNull(
            jsonFileExists(
                fileName
            )
        )
        val json = this.javaClass.classLoader?.getResource(fileName)
            ?.readText()
        return Gson().fromJson(json!!, typeOf)
    }

    private fun jsonFileExists(fileName: String): String? {
        return javaClass.classLoader?.getResource(fileName)
            ?.readText()
    }
}

enum class JSON_FILES(val fileName: String) {
    GET_LIST_OF_CURRENCIES("listOfCurrencies.json"),
}
