package com.octo.archiexampleengie.repository.common.api

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.threeten.bp.ZonedDateTime

class MoshiLocalDateTimeAdapter {
    @FromJson
    fun fromJson(date: String): ZonedDateTime = ZonedDateTime.parse(date)

    @ToJson
    fun toJson(date: ZonedDateTime): String = date.toString()
}
