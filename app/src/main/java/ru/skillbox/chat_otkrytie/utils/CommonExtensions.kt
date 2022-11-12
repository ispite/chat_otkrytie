package ru.skillbox.chat_otkrytie.utils

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

fun haveP(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.P // P версия = 9 android, API 28
}