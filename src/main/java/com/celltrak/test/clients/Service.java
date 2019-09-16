package com.celltrak.test.clients;

import com.celltrak.test.utils.Constant;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.HttpClientConfig;
import com.jayway.restassured.config.RestAssuredConfig;

import java.text.MessageFormat;

/**
 * This class contains the main methods for the RestClients.
 * @author alexis.alvarez
 */
public class Service {
    private RestAssuredConfig restAssuredConfig;
    protected ObjectMapper jsonMapper;

    public Service() {
        setConfig(RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.conn-manager.timeout", Long.valueOf(Constant.TIMEOUT_MIL_60000))
                        .setParam("http.connection-stalecheck", true)
                        .setParam("http.connection.timeout", Constant.TIMEOUT_MIL_60000)
                        .setParam("http.socket.timeout", Constant.TIMEOUT_MIL_60000)
                        .setParam("CONNECTION_MANAGER_TIMEOUT", Constant.TIMEOUT_MIL_60000)
                        .setParam("http.connection-manager.timeout", Constant.TIMEOUT_MIL_60000)));
        setJsonMapper(new ObjectMapper());
        getJsonMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public RestAssuredConfig getRestAssuredConfig() {
        return restAssuredConfig;
    }

    public void setConfig(RestAssuredConfig config) {
        this.restAssuredConfig = config;
    }

    public ObjectMapper getJsonMapper() {
        return jsonMapper;
    }

    public void setJsonMapper(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    public String buildUrl(String service, Object... params) {
        StringBuilder result = new StringBuilder();
        result.append(MessageFormat.format(service, params));
        return result.toString();
    }
}
