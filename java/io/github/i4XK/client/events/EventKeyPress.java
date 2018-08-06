package io.github.i4XK.client.events;

import io.github.i4XK.client.event.events.Event;

public class EventKeyPress implements Event {
    int key;

    public EventKeyPress(int key ){
        this.key = key;
    }

    public int key() {
        return key;
    }
}
