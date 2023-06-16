package com.microservices.training.msorder.integrations;

import java.util.function.Predicate;

public class MyRetryPredicate implements Predicate<Throwable> {

    @Override
    public boolean test(final Throwable eParam) {
        if (eParam instanceof IllegalStateException) {
            IllegalStateException stateExceptionLoc = (IllegalStateException) eParam;
            Throwable             causeLoc          = stateExceptionLoc.getCause();
            return true;
        }
        return false;
    }
}
