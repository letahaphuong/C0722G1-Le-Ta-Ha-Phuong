package com.example.case_study.controller;

import com.example.case_study.dto.attach_facility_list.AttachFacilityListView;
import com.example.case_study.model.contract.AttachFacility;
import com.example.case_study.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("attach-facility")
@CrossOrigin("*")
public class AttachFacilityRestController {

    @Autowired
    IAttachFacilityService attachFacilityService;

    @GetMapping("show/{id}")
    public ResponseEntity<Page<AttachFacilityListView>> getAttachFacilityList(@PathVariable("id") Long id,@PageableDefault(page = 0,size = 3) Pageable pageable){
        Page<AttachFacilityListView> attachFacilityListViews=attachFacilityService.getAttachFacility(id,pageable);
        if (attachFacilityListViews.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityListViews,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody AttachFacility attachFacility){
        attachFacilityService.save(attachFacility);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
