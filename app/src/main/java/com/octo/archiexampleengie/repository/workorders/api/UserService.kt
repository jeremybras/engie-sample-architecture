package com.octo.archiexampleengie.repository.workorders.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("users")
    fun getUsers(@Query("since") since: Int): Call<List<UserJSON>>

    @GET("users/:login")
    fun getUser(login: String): Call<UserJSON>
}
