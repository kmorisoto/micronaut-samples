package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.OncePerRequestHttpServerFilter
import io.micronaut.http.filter.ServerFilterChain
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import org.slf4j.LoggerFactory
import org.slf4j.MDC


@Filter("/**")
class RequestIdFilter : OncePerRequestHttpServerFilter() {
    override fun doFilterOnce(request: HttpRequest<*>, chain: ServerFilterChain): Publisher<MutableHttpResponse<*>> {
        val traceIdHeader = request.headers["traceId"]
        if (MDC.get(TRACE_ID_MDC_KEY) != null) {
            LOG.warn("MDC should have been empty here.")
        }
        LOG.info("Storing traceId in MDC: $traceIdHeader")
        MDC.put(TRACE_ID_MDC_KEY, traceIdHeader)
        return Flowable.fromPublisher(chain.proceed(request))
            .doFinally {
                LOG.info(
                    "Removing traceId id from MDC: {}",
                    MDC.get(TRACE_ID_MDC_KEY)
                )
                MDC.remove(TRACE_ID_MDC_KEY)
            }
    }

    override fun getOrder(): Int {
        return -1
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(RequestIdFilter::class.java)
        const val TRACE_ID_MDC_KEY = "traceId"
    }
}
