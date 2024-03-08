package com.example.k8s.health;

import com.example.k8s.toggle.LDToggleManager;
import com.example.k8s.toggle.Toggle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("readiness-indicator")
@ConditionalOnEnabledHealthIndicator("readiness-indicator")
public class ReadinessHealthIndicator implements HealthIndicator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadinessHealthIndicator.class);

    private final LDToggleManager toggleManager;

    public ReadinessHealthIndicator(LDToggleManager toggleManager) {
        this.toggleManager = toggleManager;
    }

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        boolean isHealthy = toggleManager.isEnabled(Toggle.READINESS);
        String result = isHealthy ? "Success" : "Failed";
        LOGGER.info("Readiness Probe Indicator.................{}", result);
        return isHealthy ? Health.up().build() : Health.down().build();
    }

}
