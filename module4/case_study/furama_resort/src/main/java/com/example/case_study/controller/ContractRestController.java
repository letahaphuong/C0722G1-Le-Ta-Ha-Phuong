package com.example.case_study.controller;

import com.example.case_study.dto.contract.ContractView;
import com.example.case_study.model.contract.Contract;
import com.example.case_study.service.contract.IAttachFacilityService;
import com.example.case_study.service.contract.IContractDetailService;
import com.example.case_study.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contract")
public class ContractRestController {

    @Autowired
    IAttachFacilityService attachFacilityService;

    @Autowired
    IContractService contractService;

    @Autowired
    IContractDetailService contractDetailService;

    @GetMapping("")
    public ResponseEntity<Iterable<ContractView>> showListContract(@PageableDefault(page = 0, size = 3)
                                                                               Pageable pageable){
        Page<ContractView> contracts=contractService.showListContract(pageable);
        if (contracts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contracts,HttpStatus.OK);
    }
}
