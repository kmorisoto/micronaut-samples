package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.UUID
import java.util.stream.IntStream
import javax.inject.Inject

@MicronautTest
class MdcTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    @field:Client("/")
    lateinit var client: RxHttpClient

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun test_mdc() {

        IntStream.rangeClosed(0, 1000000).parallel().forEach {
            val traceId = UUID.randomUUID().toString()
            val request = HttpRequest.GET<Any>("/mdc-test").header("traceId", traceId)
            val res = client.retrieve(request).blockingFirst()
            Assertions.assertEquals(res, traceId)
        }

    }

}
