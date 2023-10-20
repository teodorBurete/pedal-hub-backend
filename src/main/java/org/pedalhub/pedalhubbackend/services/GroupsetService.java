package org.pedalhub.pedalhubbackend.services;

import org.pedalhub.pedalhubbackend.entities.Groupset;
import org.pedalhub.pedalhubbackend.exceptions.ResourceNotFoundException;
import org.pedalhub.pedalhubbackend.repositories.GroupsetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Service
public class GroupsetService {

    private GroupsetRepository groupsetRepository;

    public GroupsetService(GroupsetRepository groupsetRepository) {
        this.groupsetRepository = groupsetRepository;
    }

    public Groupset findById(Long groupsetId) {
        return groupsetRepository.findById(groupsetId).orElseThrow(() -> new ResourceNotFoundException("Could not find groupset with id=" + groupsetId));
    }

    public List<Groupset> findALl() {
        return groupsetRepository.findAll();
    }
    @Transactional
    public Groupset addGroupset(Groupset newGroupset) {
        if (newGroupset.getName().isEmpty() || newGroupset.getMake().isEmpty() || newGroupset.getType().isEmpty())
            throw new IllegalArgumentException("invalid input");
        return groupsetRepository.save(newGroupset);
    }
}
