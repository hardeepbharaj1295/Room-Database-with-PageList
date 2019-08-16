package com.daemonvision.roomdatabasepagelist.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data Class that represents our items
 */
@Entity
data class Cheese(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)