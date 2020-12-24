package id.rafif.profilsekolah.model

import com.squareup.moshi.Json

data class ItemRV (
    @Json(name = "urlImg")
    var urlImg : String = "",
    @Json(name = "titleImg")
    var titleImg : String = "",
    @Json(name = "desc")
    var desc : String = "",
    var type : String = ""
)

data class Prestasi(
    @Json(name = "title")
    var title: String = "",
    @Json(name = "data")
    var data: List<ItemRV> = arrayListOf()
)