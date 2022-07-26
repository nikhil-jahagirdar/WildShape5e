package com.example.wildshape5e.repository

import com.example.wildshape5e.repository.dataobjects.MonsterDetail
import com.example.wildshape5e.repository.dataobjects.MonsterResults
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface BeastWebService {
    @GET("monsters")
    suspend fun getMonsters() : MonsterResults

    @GET("monsters/{index}")
    suspend fun getDetail(
         @Path("index") index : String
    ) : MonsterDetail

    companion object {
        @Volatile
        private var INSTANCE: BeastWebService? = null

        fun getService(): BeastWebService {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val retrofit = Retrofit.Builder()
                    // TODO: Fill in base
                    .baseUrl("https://www.dnd5eapi.co/api/")
                    .addConverterFactory(getJacksonFactory())
                    .build()
                val instance = retrofit.create(BeastWebService::class.java)
                INSTANCE = instance
                instance
            }
        }

        private fun getJacksonFactory(): JacksonConverterFactory {
            val mapper = jacksonObjectMapper()
            mapper.disable(FAIL_ON_UNKNOWN_PROPERTIES)
            return JacksonConverterFactory.create(mapper)
        }
    }
}