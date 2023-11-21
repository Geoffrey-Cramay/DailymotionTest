package com.example.dailymotiontest.data.remote.model.adapter

import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import java.io.IOException
import java.time.Instant
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.TimeZone

class OffsetDateTimeJsonAdapter : JsonAdapter<OffsetDateTime?>() {
    @Synchronized
    @Throws(IOException::class)
    override fun fromJson(reader: JsonReader): OffsetDateTime? {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull()
        } else {
            val long = reader.nextLong()
            try {
                val seconds = Instant.ofEpochSecond(long)
                val toZoneId = TimeZone.getDefault().toZoneId()
                OffsetDateTime.ofInstant(
                    seconds,
                    toZoneId
                )
            } catch (e: DateTimeParseException) {
                Log.w(TAG, e)
                null
            }
        }
    }

    @Synchronized @Throws(IOException::class) override fun toJson(
        writer: JsonWriter, value: OffsetDateTime?
    ) {
        if (value == null) {
            writer.nullValue()
        } else {
            val string = try {
                formatter.format(value)
            } catch (e: DateTimeParseException) {
                Log.w(TAG, e)
                null
            }
            if (string == null) {
                writer.nullValue()
            } else {
                writer.value(string)
            }
        }
    }

    companion object {
        private const val TAG = "OffsetDateTimeJsonAdapter"

        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")
    }
}

