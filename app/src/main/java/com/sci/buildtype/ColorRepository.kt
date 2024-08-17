package com.sci.buildtype

object ColorRepository {
    fun getColors() = listOf(
        ColorModel(
            id = "1",
            colorHax = "#FFF44336",
            colorName = "Red"
        ),
        ColorModel(
            id = "2",
            colorHax = "#9C27B0",
            colorName = "Purple"
        ),

        ColorModel(
            id = "3",
            colorHax = "#FF4CAF50",
            colorName = "Green"
        ),
        ColorModel(
            id = "4",
            colorHax = "#FF5722",
            colorName = "Orange"
        ),
        ColorModel(
            id = "5",
            colorHax = "#FFEB3B",
            colorName = "Yellow"
        )
    )
}