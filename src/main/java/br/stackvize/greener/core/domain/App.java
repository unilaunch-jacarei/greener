package br.stackvize.greener.core.domain;

import java.util.UUID;

public record App(String appName, Machine machine, UUID instanceId) {
    public App {
        if (appName == null || appName.isBlank()) {
            throw new IllegalArgumentException("The app name should not be blank.");
        }

        if (machine == null) {
            throw new IllegalArgumentException("The machine where the app is running should be informed.");
        }

        if (instanceId == null) {
            instanceId = UUID.randomUUID();
        }
    }

    public App(String appName, Machine machine) {
        this(appName, machine, UUID.randomUUID());
    }
}
