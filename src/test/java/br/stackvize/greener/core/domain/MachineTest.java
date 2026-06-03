package br.stackvize.greener.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {
    private final Zone zoneDummy = new Zone("Dummy-name", 20.0);
    private static final double MAX_WATTS_DUMMY = 200.0;
    private static final double IDLE_WATTS_DUMMY = 100.0;
    private static final double RAM_WATTS_PER_GB = 0.3;

    @Test
    void shouldCreateMachineSuccessfullyWhenValidData() {
        // given: the creation of a machine with right data
        Machine machine = new Machine("Server-01", zoneDummy, MAX_WATTS_DUMMY, IDLE_WATTS_DUMMY, RAM_WATTS_PER_GB);

        // then
        assertEquals("Server-01", machine.serverName());
        assertEquals(zoneDummy, machine.zone());
        assertEquals(200.0, machine.maxWatts());
        assertEquals(100.0, machine.idleWatts());
        assertEquals(0.3, machine.ramWattsPerGb()); // Heads up: Check if your record field is 'ramWatsPerGb' or 'ramWattsPerGb' (double 't')
    }

    @Test
    void shouldFailWhenServerNameIsNull() {
        // expect & when: creating a machine with a null server name should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Machine(null, zoneDummy, MAX_WATTS_DUMMY, IDLE_WATTS_DUMMY, RAM_WATTS_PER_GB);
        });
    }

    @Test
    void shouldFailWhenServerNameIsBlank() {
        // expect & when: a blank/empty server name should also fail
        assertThrows(IllegalArgumentException.class, () -> {
            new Machine("   ", zoneDummy, MAX_WATTS_DUMMY, IDLE_WATTS_DUMMY, RAM_WATTS_PER_GB);
        });
    }

    @Test
    void shouldFailWhenZoneIsNull() {
        // expect & when
        assertThrows(IllegalArgumentException.class, () -> {
            new Machine("Server-01", null, MAX_WATTS_DUMMY, IDLE_WATTS_DUMMY, RAM_WATTS_PER_GB);
        });
    }

    @Test
    void shouldFailWhenIdleWattsIsGreaterThanMaxWatts() {
        // given: idle watts (250) is greater than max watts (200)
        double invalidIdleWatts = 250.0;

        // expect & when
        assertThrows(IllegalArgumentException.class, () -> {
            new Machine("Server-01", zoneDummy, MAX_WATTS_DUMMY, invalidIdleWatts, RAM_WATTS_PER_GB);
        });
    }

    @Test
    void shouldFailWhenMaxWattsIsNegative() {
        // expect & when: maxWatts is -10.0
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Machine("Server-01", zoneDummy, -10.0, IDLE_WATTS_DUMMY, RAM_WATTS_PER_GB);
        });

        assertEquals("Wattage values cannot be negative.", exception.getMessage());
    }

    @Test
    void shouldFailWhenIdleWattsIsNegative() {
        // expect & when: idleWatts is -5.0
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Machine("Server-01", zoneDummy, MAX_WATTS_DUMMY, -5.0, RAM_WATTS_PER_GB);
        });

        assertEquals("Wattage values cannot be negative.", exception.getMessage());
    }

    @Test
    void shouldFailWhenRamWattsPerGbIsNegative() {
        // expect & when: ramWattsPerGb is -0.1
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Machine("Server-01", zoneDummy, MAX_WATTS_DUMMY, IDLE_WATTS_DUMMY, -0.1);
        });

        assertEquals("Wattage values cannot be negative.", exception.getMessage());
    }
}