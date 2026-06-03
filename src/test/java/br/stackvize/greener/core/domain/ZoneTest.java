package br.stackvize.greener.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneTest {

    @Test
    void shouldCreateZoneSuccessfullyWhenValidData() {
        // given: dados válidos para a zona
        String validName = "sa-east-1";
        double validIntensity = 50.5;

        // when
        Zone zone = new Zone(validName, validIntensity);

        // then
        assertEquals("sa-east-1", zone.name());
        assertEquals(50.5, zone.carbonIntensity());
    }

    @Test
    void shouldFailWhenNameIsNull() {
        // expect & when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Zone(null, 50.5);
        });

        assertEquals("Name must not be blank.", exception.getMessage());
    }

    @Test
    void shouldFailWhenNameIsBlank() {
        // expect & when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Zone("   ", 50.5);
        });

        assertEquals("Name must not be blank.", exception.getMessage());
    }

    @Test
    void shouldFailWhenCarbonIntensityIsZero() {
        // expect & when: testando o limite exato do zero
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Zone("sa-east-1", 0.0);
        });

        assertEquals("Carbon intesity cannot be zero.", exception.getMessage());
    }

    @Test
    void shouldFailWhenCarbonIntensityIsNegative() {
        // expect & when: garantindo que valores menores que zero também falham devido ao '<='
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Zone("sa-east-1", -10.5);
        });

        assertEquals("Carbon intesity cannot be zero.", exception.getMessage());
    }
}