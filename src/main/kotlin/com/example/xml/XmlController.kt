package com.example.xml

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("xml")
class XmlController {

    @Get
    @Produces(MediaType.APPLICATION_XML)
    fun xml() = HogeFuga("abc")

    @JsonRootName(value = "hoge_fuga")
    @JsonNaming(
        PropertyNamingStrategy.KebabCaseStrategy::class)
    class HogeFuga(
        val hogeName: String
    )
}
