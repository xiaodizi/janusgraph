// Copyright 2017 JanusGraph Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.janusgraph.diskstorage.opensearch.rest.util;

import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.opensearch.client.RestClientBuilder;

public class ConnectionKeepAliveConfigCallback implements RestClientBuilder.HttpClientConfigCallback {

    private final long keepAliveDuration;

    /**
     * Constructor
     * @param keepAliveDuration The keep-alive duration in milliseconds
     */
    public ConnectionKeepAliveConfigCallback(long keepAliveDuration) {
        this.keepAliveDuration = keepAliveDuration;
    }

    @Override
    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
        httpClientBuilder.setKeepAliveStrategy((a, b) -> this.keepAliveDuration);
        return httpClientBuilder;
    }
}
