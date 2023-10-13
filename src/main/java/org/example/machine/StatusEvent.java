package org.example.machine;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.StateMachineFactory;

public enum StatusEvent {
    EVENT_1(
            StatusEnum.STATUS_1,
            StatusEnum.STATUS_2,
            StatusEnum.STATUS_3::checkCondition,
            (from, to, event, ctx) -> StatusEnum.STATUS_2.doAction(ctx)
    ),

    EVENT_2(
            StatusEnum.STATUS_1,
            StatusEnum.STATUS_3,
            StatusEnum.STATUS_3::checkCondition,
            (from, to, event, ctx) -> StatusEnum.STATUS_3.doAction(ctx)
    ),

    EVENT_3(
            StatusEnum.STATUS_2,
            StatusEnum.STATUS_3,
            StatusEnum.STATUS_3::checkCondition,
            (from, to, event, ctx) -> StatusEnum.STATUS_3.doAction(ctx)
    );

    final StatusEnum from;

    final StatusEnum to;

    final Condition<StatusDomain> condition;

    final Action<StatusEnum, StatusEvent, StatusDomain> doAction;

    StatusEvent(StatusEnum from, StatusEnum to, Condition<StatusDomain> condition, Action<StatusEnum, StatusEvent, StatusDomain> doAction) {
        this.from = from;
        this.to = to;
        this.condition = condition;
        this.doAction = doAction;
    }

    public static StatusEvent getByEvent(StatusDomain domain) {
        for (StatusEvent value : StatusEvent.values()) {
            if (value.from.name().equals(domain.getOriginalStatus()) && value.to.name().equals(domain.getToStatus()))
                return value;
        }
        throw new RuntimeException("StatusEvent.getByEvent error!");
    }

    public boolean isExternalTransaction() {
        return from != to;
    }

    public void fireStateEvent(StatusDomain ctx) {
        StateMachine<StatusEnum, StatusEvent, StatusDomain> contentPublishStateMachine = StateMachineFactory.get("StatusMachine");
        contentPublishStateMachine.fireEvent(from, this, ctx);
    }
}
