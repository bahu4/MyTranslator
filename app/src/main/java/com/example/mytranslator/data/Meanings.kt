package com.example.mytranslator.data

import com.google.gson.annotations.SerializedName

class Meanings(
    @field:SerializedName(value = "translation") val translation: Translation?
)
