package com.example.k8s.health;

import com.example.k8s.toggle.LDToggleManager;
import com.example.k8s.toggle.Toggle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("liveness-indicator")
@ConditionalOnEnabledHealthIndicator("liveness-indicator")
public class LivenessHealthIndicator implements HealthIndicator {

    private static final Logger LOGGER = LoggerFactory.getLogger(LivenessHealthIndicator.class);
    private final LDToggleManager toggleManager;

    public LivenessHealthIndicator(LDToggleManager toggleManager) {
        this.toggleManager = toggleManager;
    }

    @Override
    public Health health() {
        boolean isHealthy = toggleManager.isEnabled(Toggle.LIVENESS);
        String result = isHealthy ? "Success" : "Failed";
        LOGGER.info("Liveness Probe Indicator.................{}", result);
        return isHealthy ? Health.up().build() : Health.down().build();
    }
}
