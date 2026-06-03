package br.stackvize.greener.core.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private final Zone dummyZone = new Zone("BR-Central", 2.5);

    private final Machine dummyMachine = new Machine(
            "Server-01", dummyZone, 200.0, 50.0, 0.1
    );

    @Test
    void shouldCreateAppSuccessfullyWithValidData() {
        // given: a functioning app
        App app = new App("GreenerApi", dummyMachine);

        // then
        assertEquals("GreenerApi", app.appName());
        assertEquals(dummyMachine, app.machine());
        assertNotNull(app.instanceId(), "UUID should be automatically generated.");
    }

    @Test
    void shouldFailWhenAppNameIsNull() {
        // then: a exception of type IllegalArgument should be thrown
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            // given: an app without a name
            new App(null, dummyMachine);
        });

        // and: the message should contain a descriptive information
        assertTrue(exception.getMessage().contains("The app name should not be blank."));
    }

    @Test
    void shouldFailWhenAppNameIsBlank() {
        // then: a exception of type IllegalArgument should be thrown
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // given: an app with a blank name
            new App("  ", dummyMachine);
        });

        // and: the message should contain a descriptive information
        assertTrue(exception.getMessage().contains("The app name should not be blank."));
    }

    @Test
    void shouldFailWhenMachineIsNull() {
        // then: a exception of type IllegalArgument should be thrown
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // given: an app with a null machine
            new App("Name", null);
        });

        // and: the message should contain a descriptive information
        assertTrue(exception.getMessage().contains("The machine where the app is running should be informed."));
    }

    @Test
    void shouldGenerateRandomUuidWhenPassedAsNull() {
        // given: an app explicitly instantiated with a null instanceId
        App app = new App("GreenerApi", dummyMachine, null);

        // then: it should not fail, and a random UUID should be generated anyway
        assertNotNull(app.instanceId(), "UUID should be automatically generated even if null is explicitly passed.");
    }

    @Test
    void shouldPreserveGivenUuidWhenNotNull() {
        // given: a specific predefined UUID
        UUID expectedUuid = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

        // when: creating the app with that specific UUID
        App app = new App("GreenerApi", dummyMachine, expectedUuid);

        // then: it should use the provided UUID and not overwrite it
        assertEquals(expectedUuid, app.instanceId());
    }
}