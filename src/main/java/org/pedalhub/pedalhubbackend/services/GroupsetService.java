package org.pedalhub.pedalhubbackend.services;

import org.pedalhub.pedalhubbackend.entities.Groupset;
import org.pedalhub.pedalhubbackend.exceptions.ResourceNotFoundException;
import org.pedalhub.pedalhubbackend.repositories.GroupsetRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupsetService {

    private GroupsetRepository groupsetRepository;

    public GroupsetService(GroupsetRepository groupsetRepository) {
        this.groupsetRepository = groupsetRepository;
    }

    public Groupset findById(Long groupsetId) {
        return groupsetRepository.findById(groupsetId).orElseThrow(() -> new ResourceNotFoundException("Could not find groupset with id=" + groupsetId));
    }
}
