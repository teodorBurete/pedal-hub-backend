package org.pedalhub.pedalhubbackend.controllers;

import org.pedalhub.pedalhubbackend.entities.Groupset;
import org.pedalhub.pedalhubbackend.services.GroupsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupsets")
public class GroupsetController {

    private GroupsetService groupsetService;

    @Autowired
    public GroupsetController(GroupsetService groupsetService) {
        this.groupsetService = groupsetService;
    }

    @GetMapping
    public List<Groupset> findAll() {
        return groupsetService.findALl();
    }

    @GetMapping("/{id}")
    public Groupset findById(@PathVariable(name = "id") Long id) {
        return groupsetService.findById(id);
    }

    @PostMapping("")
    public Groupset addGroupset(@RequestBody Groupset groupset) {
        return groupsetService.addGroupset(groupset);
    }

}
