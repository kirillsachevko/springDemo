package com.epam.javadv.spring.actuator;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Endpoint(id = "features")
@Component
public class CustomActuatorEndpoint {
    private final Map<String, String> features = new ConcurrentHashMap<>();

    @ReadOperation
    public String feature(@RequestParam String param) {
        features.put("param", param);
        return features.get("param");
    }

    @WriteOperation
    public void configureFeature(@RequestParam String param, @RequestParam String alias) {
        features.put(alias, param);
    }

    @DeleteOperation
    public void deleteFeature(@RequestParam String param) {
        features.remove(param);
    }
}
