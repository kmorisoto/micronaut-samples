package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid
import javax.validation.constraints.NotEmpty

@Validated
@Controller("/hello")
class HelloController {

    // curl http://localhost:8080/hello
    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        return "Hello World"
    }

    // curl -X POST --location "http://localhost:8080/hello" -v
    @Post
    fun post(): HttpResponse<*> = HttpResponse.ok<Any>()

    @Get("/foo")
    fun foo(): Foo = Foo("aaa")

    @Post("/foo")
    fun foo(httpHeaders: HttpHeaders, @Body @Valid foo: Foo): Foo {
        println(httpHeaders)
        return foo
    }
}

@Introspected
data class Foo(
    @field:NotEmpty
    val name: String
)
