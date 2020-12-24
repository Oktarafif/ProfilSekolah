package id.rafif.profilsekolah.retrofit

import androidx.lifecycle.LiveData
import id.rafif.profilsekolah.model.ItemRV
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {

    // JSon berasal dari moshi

    @GET( "data/eskul.json")
    suspend fun getDataEskul(): Response<List<ItemRV>>

    @GET("data/Galeri.json")
    suspend fun getDataGaleri(): Response<List<ItemRV>>
}