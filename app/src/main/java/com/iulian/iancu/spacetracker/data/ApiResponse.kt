package com.iulian.iancu.spacetracker.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @Expose
    @SerializedName("links")
    val links: Links,
    @Expose
    @SerializedName("static_fire_date_utc")
    val static_fire_date_utc: String,
    @Expose
    @SerializedName("static_fire_date_unix")
    val static_fire_date_unix: Int,
    @Expose
    @SerializedName("tdb")
    val tdb: Boolean,
    @Expose
    @SerializedName("net")
    val net: Boolean,
    @Expose
    @SerializedName("window")
    val window: Int,
    @Expose
    @SerializedName("rocket")
    val rocket: String,
    @Expose
    @SerializedName("success")
    val success: Boolean,
    @Expose
    @SerializedName("failures")
    val failures: List<String>,
    @Expose
    @SerializedName("details")
    val details: String,
    @Expose
    @SerializedName("crew")
    val crew: List<String>,
    @Expose
    @SerializedName("ships")
    val ships: List<String>,
    @Expose
    @SerializedName("capsules")
    val capsules: List<String>,
    @Expose
    @SerializedName("payloads")
    val payloads: List<String>,
    @Expose
    @SerializedName("launchpad")
    val launchpad: String,
    @Expose
    @SerializedName("auto_update")
    val auto_update: Boolean,
    @Expose
    @SerializedName("flight_number")
    val flight_number: Int,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("date_utc")
    val date_utc: String,
    @Expose
    @SerializedName("date_unix")
    val date_unix: Int,
    @Expose
    @SerializedName("date_local")
    val date_local: String,
    @Expose
    @SerializedName("date_precision")
    val date_precision: String,
    @Expose
    @SerializedName("upcoming")
    val upcoming: Boolean,
    @Expose
    @SerializedName("cores")
    val cores: List<Cores>,
    @Expose
    @SerializedName("id")
    val id: String
)

data class Cores(
    @Expose
    @SerializedName("core")
    val core: String,
    @Expose
    @SerializedName("flight")
    val flight: Int,
    @Expose
    @SerializedName("gridfins")
    val gridfins: Boolean,
    @Expose
    @SerializedName("legs")
    val legs: Boolean,
    @Expose
    @SerializedName("reused")
    val reused: Boolean,
    @Expose
    @SerializedName("landing_attempt")
    val landing_attempt: Boolean,
    @Expose
    @SerializedName("landing_success")
    val landing_success: Boolean,
    @Expose
    @SerializedName("landing_type")
    val landing_type: String,
    @Expose
    @SerializedName("landpad")
    val landpad: String
)

data class Links(
    @Expose
    @SerializedName("patch")
    val patch: Patch,
    @Expose
    @SerializedName("reddit")
    val reddit: Reddit,
    @Expose
    @SerializedName("flickr")
    val flickr: Flickr,
    @Expose
    @SerializedName("presskit")
    val presskit: String,
    @Expose
    @SerializedName("webcast")
    val webcast: String,
    @Expose
    @SerializedName("youtube_id")
    val youtube_id: String,
    @Expose
    @SerializedName("article")
    val article: String,
    @Expose
    @SerializedName("wikipedia")
    val wikipedia: String
)

data class Flickr(
    @Expose
    @SerializedName("small")
    val small: List<String>,
    @Expose
    @SerializedName("original")
    val original: List<String>
)

data class Reddit(
    @Expose
    @SerializedName("campaign")
    val campaign: String,
    @Expose
    @SerializedName("launch")
    val launch: String,
    @Expose
    @SerializedName("media")
    val media: String,
    @Expose
    @SerializedName("recovery")
    val recovery: String
)

data class Patch(
    @Expose
    @SerializedName("small")
    val small: String,
    @Expose
    @SerializedName("large")
    val large: String
)