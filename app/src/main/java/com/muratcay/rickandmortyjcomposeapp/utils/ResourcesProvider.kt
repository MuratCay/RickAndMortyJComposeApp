package com.muratcay.rickandmortyjcomposeapp.utils

import android.content.Context
import java.util.Locale

class ResourcesProvider(private val context: Context) {
    fun getString(resId: Int): String {
        return context.getString(resId)
    }

    fun getLanguage(): String {
        return Locale.getDefault().language
    }
}