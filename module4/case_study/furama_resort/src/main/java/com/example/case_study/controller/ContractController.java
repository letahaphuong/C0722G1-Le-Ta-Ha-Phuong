package com.example.case_study.controller;

import com.example.case_study.service.contract.IAttachFacilityService;
import com.example.case_study.service.contract.IContractDetailService;
import com.example.case_study.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("contract")
public class ContractController {

    final
    IContractDetailService contractDetailService;

    final
    IContractService contractService;

    final
    IAttachFacilityService attachFacilityService;

    public ContractController(IContractDetailService contractDetailService, IContractService contractService, IAttachFacilityService attachFacilityService) {
        this.contractDetailService = contractDetailService;
        this.contractService = contractService;
        this.attachFacilityService = attachFacilityService;
    }
//
//    @GetMapping("")
//    public String showList(Model model,@PageableDefault(page = 0, size = 3) Pageable pageable){
//        model.addAttribute("contractList",contractService.showListContract(pageable));
//        return "contract/list";
//    }
}
