package com.titanio.app.utils

import androidx.appcompat.app.AppCompatDelegate

object Utilities {
    fun disableNightMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}