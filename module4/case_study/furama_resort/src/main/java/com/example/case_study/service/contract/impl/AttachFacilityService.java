package com.example.case_study.service.contract.impl;

import com.example.case_study.model.contract.AttachFacility;
import com.example.case_study.repository.contract.IAttachFacilityRepository;
import com.example.case_study.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public Optional<AttachFacility> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(AttachFacility attachFacility) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void removeFlag(Long id) {

    }
}
