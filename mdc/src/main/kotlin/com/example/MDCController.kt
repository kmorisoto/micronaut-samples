package com.example

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.slf4j.MDC

@Controller
class MDCController {
    @Get("/mdc-test")
    fun getMdc(): HttpResponse<*> {
        val mdc = MDC.getCopyOfContextMap()
        return HttpResponse.ok(mdc[RequestIdFilter.TRACE_ID_MDC_KEY])
    }
}
