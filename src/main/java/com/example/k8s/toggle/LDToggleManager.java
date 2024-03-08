package com.example.k8s.toggle;

import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.server.LDClient;
import org.springframework.stereotype.Component;

@Component
public class LDToggleManager implements ToggleManager {

    private static final LDContext CONTEXT = LDContext.create("Unknown");
    private final LDClient ldClient;

    public LDToggleManager(LDClient ldClient) {
        this.ldClient = ldClient;
    }

    @Override
    public boolean isEnabled(Toggle toggle) {
        return ldClient.boolVariation(toggle.name(), CONTEXT, false);
    }
}
