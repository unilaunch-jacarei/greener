package br.stackvize.greener.core.domain;

public record Machine(String serverName, Zone zone, double maxWatts, double idleWatts, double ramWattsPerGb) {
    public Machine {
        if (serverName == null || serverName.isBlank()) {
            throw new IllegalArgumentException("The server name must not be blank.");
        }

        if (zone == null) {
            throw new IllegalArgumentException("Zone should not be null.");
        }

        if (maxWatts < 0 || idleWatts < 0 || ramWattsPerGb < 0) {
            throw new IllegalArgumentException("Wattage values cannot be negative.");
        }

        if (maxWatts < idleWatts) {
            throw new IllegalArgumentException("How maxWatts is greater then idleWatts.");
        }
    }
}
