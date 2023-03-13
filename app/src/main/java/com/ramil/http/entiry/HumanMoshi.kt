package com.ramil.http.entiry

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HumanMoshi(
    @Json(name = "name") val name : String,
    @Json(name = "middle_name") val middle_name : String)