package com.example.dailymotiontest.presentation.formatter

import android.content.res.Resources
import com.example.dailymotiontest.R
import java.time.Clock
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

class VideoCreationTimeFormatterImpl(
    private val clock: Clock,
    private val resources: Resources,
) : VideoCreationTimeFormatter {
    override fun format(creationTime: OffsetDateTime): String {
        val nowOffsetDateTime = OffsetDateTime.now(clock)
        val seconds = ChronoUnit.SECONDS.between(creationTime, nowOffsetDateTime)
        if (seconds < ONE_MINUTE) {
            return resources.getString(R.string.creation_time_just_now)
        }
        val minutes = ChronoUnit.MINUTES.between(creationTime, nowOffsetDateTime).toInt()
        if (minutes < ONE_HOUR) {
            return resources.getQuantityString(
                R.plurals.creation_time_minutes_ago,
                minutes,
                minutes
            )
        }
        val hours = ChronoUnit.HOURS.between(creationTime, nowOffsetDateTime).toInt()
        if (hours < ONE_DAY) {
            return resources.getQuantityString(R.plurals.creation_time_hours_ago, hours, hours)
        }
        val days = ChronoUnit.DAYS.between(creationTime, nowOffsetDateTime).toInt()
        if (days < ONE_WEEK) {
            return resources.getQuantityString(R.plurals.creation_time_days_ago, days, days)
        }
        if (days == ONE_WEEK) {
            return resources.getString(R.string.creation_time_week_ago_one)
        }
        val weeks = ChronoUnit.WEEKS.between(creationTime, nowOffsetDateTime).toInt()
        if (weeks < TWO_WEEKS) {
            return resources.getString(R.string.creation_time_week_ago_one)
        }
        val months = ChronoUnit.MONTHS.between(creationTime, nowOffsetDateTime).toInt()
        if (months < TWELVE_MONTHS) {
            return resources.getQuantityString(R.plurals.creation_time_months_ago, months, months)
        }
        val years = ChronoUnit.YEARS.between(creationTime, nowOffsetDateTime).toInt()
        return resources.getQuantityString(R.plurals.creation_time_years_ago, years, years)
    }

    companion object {
        private const val ONE_MINUTE = 60
        private const val ONE_HOUR = 60
        private const val ONE_DAY = 24
        private const val ONE_WEEK = 7
        private const val TWO_WEEKS = 2
        private const val TWELVE_MONTHS = 12
    }
}