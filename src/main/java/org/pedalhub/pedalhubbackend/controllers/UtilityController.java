package org.pedalhub.pedalhubbackend.controllers;

import org.pedalhub.pedalhubbackend.entities.advanced_search.enums.FilterKey;
import org.pedalhub.pedalhubbackend.entities.advanced_search.enums.SearchOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UtilityController {
    public UtilityController() {

    }

    @GetMapping("/searchOperations")
    public ResponseEntity<Object> getOperations() {
        Map<String, Object> map = new HashMap<>();
        map.put("filterKeys", FilterKey.filterKeysMap());
        map.put("operations", SearchOperation.getMap());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
