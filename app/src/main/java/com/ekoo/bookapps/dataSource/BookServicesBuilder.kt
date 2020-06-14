package com.ekoo.bookapps.dataSource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BookServicesBuilder {
    fun build(): BookServices {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://cabaca.id:8443/")
            .build()
        return retrofit.create(BookServices::class.java)
    }
}