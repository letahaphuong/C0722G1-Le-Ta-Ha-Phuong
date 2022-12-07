package com.example.case_study.service.facility.impl;

import com.example.case_study.model.facility.Facility;
import com.example.case_study.repository.facility.IFacilityRepository;
import com.example.case_study.repository.facility.IFacilityTypeRepository;
import com.example.case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Optional<Facility> findById(Long id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(Long id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> searchName(String search, Pageable pageable) {
        return facilityRepository.searchName(search, search, pageable);
    }

    @Override
    public void removeFlag(Long id) {

    }
}
