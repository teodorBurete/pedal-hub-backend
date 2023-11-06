package org.pedalhub.pedalhubbackend.entities.advanced_search.enums;

import java.util.HashMap;
import java.util.Map;

public enum SearchOperation {

    EQUAL("eq"), IN("in"), LESS_OR_EQUAL("le"), GREATER_OR_EQUAL("ge");
    private final String key;
    private static final Map<SearchOperation, String> BY_KEY = new HashMap<>();

    static {
        for (SearchOperation s : values())
            BY_KEY.put(s, s.key);
    }

    private SearchOperation(String key) {
        this.key = key;
    }

    public static Map<SearchOperation, String> getMap() {
        return BY_KEY;
    }

    public String getKey() {
        return this.key;
    }


}
