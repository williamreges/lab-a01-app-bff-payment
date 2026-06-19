package com.example.payment.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class WiremockRecordStepDefs {

    private final RestTemplate restTemplate;

    public WiremockRecordStepDefs() {
        this.restTemplate = new RestTemplate();
    }


    @Before(value = "@record", order = 0)
    public void startRecording(Scenario scenario) {
        restTemplate.postForEntity(
                "http://localhost:8089/__admin/recordings/start",
                Map.of(
                        "targetBaseUrl",
                        "http://localhost:8000"),
                String.class
        );

        statusWireMockRecording(scenario);
    }

    @After(value = "@record", order = 0)
    public void stopRecording(Scenario scenario) {

        restTemplate.postForEntity(
                "http://localhost:8089/__admin/recordings/stop",
                null,
                String.class
        );

        statusWireMockRecording(scenario);
    }

    private void statusWireMockRecording(Scenario scenario) {
        var status =
                restTemplate.getForObject(
                        "http://localhost:8089/__admin/recordings/status",
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
