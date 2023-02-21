package www.iesmurgi.inmobiliariaapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface InmuebleApiService {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.131:8080/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @GET("inmuebles/paginable")
    fun getInmueble(@Query("page") page: Int, @Query("size") size: Int): Call<InmuebleResponse>

    @DELETE("inmuebles/{id}")
    fun deleteInmueble(@Path("id") id: Int): Call<Void>

    @POST("inmuebles")
    fun altaInmueble(@Body inmueble: Inmueble): Call<Inmueble>

    @POST("inmuebles/{id}")
    fun editarInmueble(@Path("id") id: Int, @Body inmueble: Inmueble): Call<Inmueble>

}