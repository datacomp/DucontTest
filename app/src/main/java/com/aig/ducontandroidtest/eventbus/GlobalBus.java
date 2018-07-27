package com.aig.ducontandroidtest.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by cgadmin on 2/12/18.
 */

public class GlobalBus {

    private static EventBus eventBus;
    public static EventBus getEventBus(){
        if(eventBus == null){
            eventBus = EventBus.getDefault();
        }
        return eventBus;

    }
}
