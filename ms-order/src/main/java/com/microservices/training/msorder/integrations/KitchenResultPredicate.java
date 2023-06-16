package com.microservices.training.msorder.integrations;

import java.util.function.Predicate;

public class KitchenResultPredicate implements Predicate<String> {

    @Override
    public boolean test(final String sParam) {
        return sParam.contains("osman");
    }
}
