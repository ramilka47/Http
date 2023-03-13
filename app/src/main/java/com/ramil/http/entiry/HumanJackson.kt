package com.ramil.http.entiry

import com.fasterxml.jackson.annotation.JsonProperty

data class HumanJackson(
    @JsonProperty("name") val name : String,
    @JsonProperty("middle_name") val middle_name : String)