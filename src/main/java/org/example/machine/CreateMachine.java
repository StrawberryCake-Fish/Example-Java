package org.example.machine;

import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;

public class CreateMachine {
    public void create() {
        StateMachineBuilder<StatusEnum, StatusEvent, StatusDomain> stateMachineBuilder = StateMachineBuilderFactory.create();
        for (StatusEvent event : StatusEvent.values()) {
            if (event.isExternalTransaction()) {
                stateMachineBuilder.externalTransition()
                        .from(event.from)
                        .to(event.to)
                        .on(event)
                        .when(event.condition)
                        .perform(event.doAction);
            } else {
                stateMachineBuilder.internalTransition()
                        .within(event.from)
                        .on(event)
                        .when(event.condition)
                        .perform(event.doAction);
            }
        }
        stateMachineBuilder.build("StatusMachine");
    }
}
