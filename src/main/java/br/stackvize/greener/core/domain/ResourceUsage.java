package br.stackvize.greener.core.domain;

public record ResourceUsage(
        double cpuUsage,
        double ramUsage // GB não Bytes
) {

    public ResourceUsage {
        if (cpuUsage < 0) cpuUsage = 0;

        if (ramUsage < 0) {
            throw new IllegalArgumentException("Ram usage lower then 0.");
        }
    }
}
