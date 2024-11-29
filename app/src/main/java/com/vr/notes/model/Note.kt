package com.vr.notes.model

data class Note(
    val id: Long,
    val userId: Long,
    val title: String,
    val note: String
)