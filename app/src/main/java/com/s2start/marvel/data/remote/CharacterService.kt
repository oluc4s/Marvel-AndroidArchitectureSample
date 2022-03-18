package com.s2start.marvel.data.remote

import com.s2start.marvel.data.entities.Authentication
import com.s2start.marvel.data.entities.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {
    @GET("characters")
    suspend fun getAllCharacters(
        @Query("hash") hash:String = Authentication().hash,
        @Query("apikey") apikey:String = Authentication().publicKey,
        @Query("ts") ts:String = Authentication().ts
    ) : Response<CharacterDataWrapper>

    @GET("characters/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<CharacterDataWrapper>
}