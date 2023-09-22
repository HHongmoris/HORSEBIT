package com.a406.horsebit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface APIS {

    // 로그인
    @POST("/api/auth/login")
    fun login(
        @Header("Authorization") authorization: String,
    )
//    :Call<ArrayList<>>

    // 회원가입

    // 닉네임 중복체크

    // 미체결 내역 조회
    @GET("/api/exchange/orders/{tokenNo}")
    fun notConcluded(
        @Path("tokenNo") tokenNo: Long,
        @Header("Authorization") authorization: String,
    ): Call<ArrayList<NotConcludedResponseBodyOrderModel>>

    // 체결 내역 조회
    @GET("/api/exchange/executions/{tokenNo}")
    fun concluded(
        @Path("tokenNo") tokenNo: Long,
        @Header("Authorization") authorization: String,
    ): Call<ArrayList<ConcludedResponseBodyOrderModel>>

    // 코인 목록 조회 (SSE)
    @GET("/api/exchange/tokens")
    fun tokenList(
        @Header("Authorization") authorization: String,
    ): Call<ArrayList<Token>>

    companion object {
        private const val BASE_URL = "https://j9a406.p.ssafy.io"

        fun create(): APIS {
            val gson : Gson = GsonBuilder().setLenient().create();

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIS::class.java)
        }
    }
}