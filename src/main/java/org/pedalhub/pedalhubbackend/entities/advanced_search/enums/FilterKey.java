package org.pedalhub.pedalhubbackend.entities.advanced_search.enums;

import java.util.*;

public enum FilterKey {

    CATEGORY("category", Arrays.asList(SearchOperation.IN.getKey(), SearchOperation.EQUAL.getKey()), "String"),
    BRAND("brand", Arrays.asList(SearchOperation.EQUAL.getKey(), SearchOperation.IN.getKey()), "String"),
    FRAME_MATERIAL("frameMaterial", Arrays.asList(SearchOperation.IN.getKey(), SearchOperation.EQUAL.getKey()), "String"),
    BRAKES_TYPE("brakesType", Arrays.asList(SearchOperation.IN.getKey(), SearchOperation.EQUAL.getKey()), "String"),
    YEAR("year", Arrays.asList(SearchOperation.EQUAL.getKey(), SearchOperation.IN.getKey()), "Integer"),
    PRICE("price", Arrays.asList(SearchOperation.GREATER_OR_EQUAL.getKey(), SearchOperation.LESS_OR_EQUAL.getKey()), "Double");
    private final String key;
    private final String dataType;
    private final List<String> acceptedOperations;


    private FilterKey(String key, List<String> acceptedOperations, String dataType) {
        this.key = key;
        this.acceptedOperations = acceptedOperations;
        this.dataType = dataType;


    }

    private Map<String, Object> map() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", key);
        map.put("dataType", dataType);
        map.put("acceptedOperations", acceptedOperations);
        return map;
    }

    public static ArrayList<String> getKeys() {
        ArrayList<String> keys = new ArrayList<>();
        for (FilterKey filterKey : values())
            keys.add(filterKey.key);
        return keys;

    }

    public static Map<FilterKey, Object> filterKeysMap() {
        HashMap<FilterKey, Object> filterKeysMap = new HashMap<>();
        for (FilterKey f : values())
            filterKeysMap.put(f, f.map());

        return filterKeysMap;
    }
}
