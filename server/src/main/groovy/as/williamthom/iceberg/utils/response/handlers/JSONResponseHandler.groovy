package as.williamthom.iceberg.utils.response.handlers

import as.williamthom.iceberg.conf.UrlResponseConfig
import as.williamthom.iceberg.conf.UrlStatusResult
import as.williamthom.iceberg.utils.response.ResponseType
import groovy.util.logging.Slf4j

import javax.inject.Singleton

@Slf4j
@Singleton
class JSONResponseHandler implements ResponseHandler {

    Map handleResponse(final UrlStatusResult result) {
        Map body = result.body
        Map extracted = result.urlEntry.response.values.collectEntries {
            [(it.label): body.get(it.key, "<Missing>")]
        }

        return extracted
    }

    @Override
    ResponseType getResponseType() {
        return ResponseType.JSON
    }

}
