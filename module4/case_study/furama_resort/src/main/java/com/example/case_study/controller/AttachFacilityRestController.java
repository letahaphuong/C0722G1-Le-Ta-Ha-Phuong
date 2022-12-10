package com.example.case_study.controller;

import com.example.case_study.dto.attach_facility_list.AttachFacilityListView;
import com.example.case_study.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("attach-facility")
public class AttachFacilityController {

    @Autowired
    IAttachFacilityService attachFacilityService;

    @GetMapping("show/{id}")
    public ResponseEntity<List<AttachFacilityListView>> getAttachFacilityList(@PathVariable("id") Long id){
        List<AttachFacilityListView> attachFacilityListViews=attachFacilityService.getAttachFacility(id);
        if (attachFacilityListViews.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityListViews,HttpStatus.OK);
    }

}
