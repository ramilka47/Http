package com.ramil.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.ramil.http.entiry.Human
import com.ramil.http.entiry.HumanJackson
import com.ramil.http.entiry.HumanMoshi
import com.squareup.moshi.Moshi

const val JSON_STRING = "{\"name\":\"Ramil\", \"middle_name\":\"Aminev\"}"

fun gsonFromJson(json : String) : Human =
    Gson().fromJson<Human>(json, Human::class.java)

fun jacksonFromJson(json : String) : HumanJackson =
    ObjectMapper().readValue(json, HumanJackson::class.java)

fun moshiFromJson(json : String) : HumanMoshi? =
    Moshi.Builder().build().adapter<HumanMoshi>(HumanMoshi::class.java).fromJson(json)