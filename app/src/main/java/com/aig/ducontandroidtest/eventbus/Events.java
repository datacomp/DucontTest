package com.aig.ducontandroidtest.eventbus;

import com.aig.ducontandroidtest.models.list.Result;

/**
 * Created by cgadmin on 2/12/18.
 */

public class Events {

   public static class FragmentToActivityMessage{
        String message;

        public FragmentToActivityMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static class ActivityToFragmentMessage{
        Result message;

        public ActivityToFragmentMessage(Result message) {
            this.message = message;
        }

        public Result getMessage() {
            return message;
        }
    }

    public static class ActivityToActivityMessage{
        String message;

        public ActivityToActivityMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
