package com.example.payment.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class WiremockRecordStepDefs {

    private static final String URL_RECORD_START = "http://localhost:%s/__admin/recordings/start";
    public static final String URL_RECORD_STOP = "http://localhost:%s/__admin/recordings/stop";
    public static final String URL_RECORD_STATUS = "http://localhost:%s/__admin/recordings/status";

    private final Integer portWiremock;

    private final String targetUrl;

    private final RestTemplate restTemplate;

    public WiremockRecordStepDefs(
            @Value("${wiremock.port}") Integer portWiremock,
            @Value("${wiremock.record.target-url}") String targetUrl) {
        this.portWiremock = portWiremock;
        this.targetUrl = targetUrl;
        this.restTemplate = new RestTemplate();
    }


    @Before(value = "@record", order = 0)
    public void startRecording(Scenario scenario) {
        restTemplate.postForEntity(
                URL_RECORD_START.formatted(portWiremock),
                Map.of(
                        "targetBaseUrl",
                        targetUrl),
                String.class
        );

        statusWireMockRecording(scenario);
    }

    @After(value = "@record", order = 0)
    public void stopRecording(Scenario scenario) {

        restTemplate.postForEntity(
                URL_RECORD_STOP.formatted(portWiremock),
                null,
                String.class
        );

        statusWireMockRecording(scenario);
    }

    private void statusWireMockRecording(Scenario scenario) {
        var status =
                restTemplate.getForObject(
                        URL_RECORD_STATUS.formatted(portWiremock),
                        String.class
                );

        scenario.log(
                """
                        Cenário: %s;
                        Status do WireMock Record: : %s
                        """.formatted(scenario.getName(), status)
        );
    }

}
