package com.example

import io.micronaut.runtime.Micronaut.*
import org.springframework.stereotype.Controller

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("com.example")
        .start()
}
