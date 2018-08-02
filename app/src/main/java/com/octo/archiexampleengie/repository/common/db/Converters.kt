package com.octo.archiexampleengie.repository.common.db

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.Instant
import org.threeten.bp.ZoneId
import org.threeten.bp.ZoneOffset
import org.threeten.bp.ZonedDateTime

object Converters {

    @TypeConverter
    @JvmStatic
    fun longToZonedDateTime(long: Long?): ZonedDateTime? =
        long?.let {
            Instant.ofEpochSecond(long).atZone(ZoneOffset.UTC)
                .withZoneSameInstant(ZoneId.systemDefault())
        }


    @TypeConverter
    @JvmStatic
    fun zonedDateTimeToLong(zdt: ZonedDateTime?): Long? =
        zdt?.withZoneSameInstant(ZoneOffset.UTC)?.toEpochSecond()
}