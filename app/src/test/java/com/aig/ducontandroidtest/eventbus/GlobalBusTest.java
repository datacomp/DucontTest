package com.aig.ducontandroidtest.eventbus;

import com.aig.ducontandroidtest.list.view.ListFragment;

import org.greenrobot.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class GlobalBusTest {

    EventBus eventBus;

    @Before
    public void setUp() throws Exception {

        eventBus = Mockito.mock(EventBus.class);
    }

    @Test
    public void getEventBus() {
        if(eventBus == null)
            eventBus = EventBus.getDefault();

    }
}