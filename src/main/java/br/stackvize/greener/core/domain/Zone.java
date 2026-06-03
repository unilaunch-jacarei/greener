package br.stackvize.greener.core.domain;

public record Zone(String name, double carbonIntensity) {
    public Zone {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank.");
        }

        if (carbonIntensity <= 0) {
            throw new IllegalArgumentException("Carbon intesity cannot be zero.");
        }
    }
}
