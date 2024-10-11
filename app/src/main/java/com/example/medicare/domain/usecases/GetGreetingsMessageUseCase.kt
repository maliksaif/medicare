package com.example.medicare.domain.usecases

import android.os.Build
import java.time.LocalTime
import java.util.Calendar
import javax.inject.Inject


class GetGreetingsMessageUseCase @Inject constructor() {

    operator fun invoke(): String {
        val currentHour = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalTime.now().hour
        } else {
            Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        }
        return when (currentHour) {
            in 0..4 -> "Good Night"
            in 5..11 -> "Good Morning"
            in 12..17 -> "Good Afternoon"
            in 18..23 -> "Good Evening"
            else -> "-" // This should never happen added this for safety
        }
    }

}

