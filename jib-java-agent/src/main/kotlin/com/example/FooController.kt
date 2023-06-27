package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class FooController {
    @Get("/foo")
    fun foo(): String = "foo"
}
