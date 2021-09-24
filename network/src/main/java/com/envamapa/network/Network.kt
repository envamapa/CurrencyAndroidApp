package com.envamapa.network

interface Network {
    fun <T> getServices(clazz: Class<T>): T
}
