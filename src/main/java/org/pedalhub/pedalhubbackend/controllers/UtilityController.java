package org.pedalhub.pedalhubbackend.controllers;

import org.pedalhub.pedalhubbackend.entities.advanced_search.enums.FilterKey;
import org.pedalhub.pedalhubbackend.entities.advanced_search.enums.SearchOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UtilityController {
    public UtilityController() {

    }

    @GetMapping("/searchOperations")
    public Map<String, Object> getOperations() {
        Map<String, Object> response = new HashMap<>();
        response.put("filterKeys", FilterKey.filterKeysMap());
        response.put("operations", SearchOperation.getMap());
        return response;
    }
}
