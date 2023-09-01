package com.poc.demo.es.events;

import java.util.Date;
import java.util.UUID;

public class Event {

    public final UUID id = UUID.randomUUID();

    public final Date created = new Date();
}
