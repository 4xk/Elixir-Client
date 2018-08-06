package io.github.i4XK.client.events;

import io.github.i4XK.client.event.events.Event;

public class EventRenderHUD implements Event {
    float partialTicks;

    public EventRenderHUD(float partialTicks ){
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}
