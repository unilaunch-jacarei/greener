package br.stackvize.greener.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceUsageTest {
    @Test
    void shouldCreateResourceUsageSuccessfullyWithValidData() {
        // given: valores válidos de CPU e RAM
        double validCpu = 45.5;
        double validRam = 8.0; // 8 GB

        // when: criamos o registro
        ResourceUsage usage = new ResourceUsage(validCpu, validRam);

        // then: os valores devem ser armazenados corretamente
        assertEquals(45.5, usage.cpuUsage());
        assertEquals(8.0, usage.ramUsage());
    }

    @Test
    void shouldNormalizeCpuToZeroWhenItIsNegative() {
        // given: um valor negativo de CPU (-15.0) e uma RAM válida
        double negativeCpu = -15.0;
        double validRam = 4.0;

        // when: instanciamos o record
        ResourceUsage usage = new ResourceUsage(negativeCpu, validRam);

        // then: o construtor compacto deve normalizar a CPU para 0, sem estourar erro
        assertEquals(0.0, usage.cpuUsage(), "A CPU negativa deve ser corrigida para 0.0");
        assertEquals(4.0, usage.ramUsage());
    }

    @Test
    void shouldAcceptCpuExactlyAtZero() {
        // given & when: CPU exatamente em 0
        ResourceUsage usage = new ResourceUsage(0.0, 16.0);

        // then
        assertEquals(0.0, usage.cpuUsage());
    }

    @Test
    void shouldFailWhenRamUsageIsNegative() {
        // given: um valor inválido (negativo) para a RAM
        double invalidRam = -1.0;

        // expect & when: deve lançar IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new ResourceUsage(50.0, invalidRam);
        });

        // and: valida a mensagem de erro que você definiu
        assertEquals("Ram usage lower then 0.", exception.getMessage());
    }
}