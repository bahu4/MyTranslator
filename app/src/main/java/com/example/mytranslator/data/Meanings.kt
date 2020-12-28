package com.example.mytranslator.data

import com.google.gson.annotations.SerializedName

class Meanings(
    @field:SerializedName(value = "translation") val translation: Translation?,
    @field:SerializedName("imageUrl") val imageUrl: String?
)
