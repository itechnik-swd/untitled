package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MissionCompleteTest {

    @Test
    void executeTest() {

        MissionComplete mission = new MissionComplete();

        Mockito.when(mission.execute()).thenReturn(true);

        boolean result = mission.execute();

        assertTrue(result);

    }

}
