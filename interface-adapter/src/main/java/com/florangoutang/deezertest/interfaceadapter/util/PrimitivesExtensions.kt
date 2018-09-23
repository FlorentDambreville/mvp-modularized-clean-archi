package com.florangoutang.deezertest.interfaceadapter.util

fun Int?.zeroOrValue() : Int {
    return when(this) {
        null -> 0
        else -> this
    }
}

fun String?.emptyOrValue() : String {
    return when(this) {
        null -> ""
        else -> this
    }
}