package org.example.machine;

import org.testng.annotations.Test;

public class TestStateMachine {

    @Test
    public void print() {
        CreateMachine createMachine = new CreateMachine();
        createMachine.create();
        StatusDomain domain = new StatusDomain();
        domain.setOriginalStatus("STATUS_1")
                .setToStatus("STATUS_2");
        StatusEvent.getByEvent(domain).fireStateEvent(domain);
    }
}
