package com.example.paging3project

fun main() {
    val colors = listOf(ColorVal(1), ColorVal(5), ColorVal(9), ColorVal(10))
    val colorValue = colors.map { it.value }

    colorValue.forEach{
        println(it)
    }
}

class ColorVal(val value: Int)