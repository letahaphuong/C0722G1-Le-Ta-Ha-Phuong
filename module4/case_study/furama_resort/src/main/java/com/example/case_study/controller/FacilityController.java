package com.example.case_study.controller;

import com.example.case_study.model.facility.Facility;
import com.example.case_study.service.facility.IFacilityService;
import com.example.case_study.service.facility.IFacilityTypeService;
import com.example.case_study.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("facility")
public class FacilityController {

    final
    IFacilityService facilityService;

    final
    IFacilityTypeService facilityTypeService;

    final
    IRentTypeService rentTypeService;

    public FacilityController(IFacilityService facilityService, IFacilityTypeService facilityTypeService, IRentTypeService rentTypeService) {
        this.facilityService = facilityService;
        this.facilityTypeService = facilityTypeService;
        this.rentTypeService = rentTypeService;
    }

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String search, Model model, @PageableDefault(page = 0,size = 3)Pageable pageable){
        Page<Facility> facilities = facilityService.searchName(search, pageable);
        model.addAttribute("facilityList",facilities);
        return "facility/list";
    }

    @GetMapping("/show-list-create")
    public String showFormCreate( Model model){
        model.addAttribute("facility",new Facility());
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        return "facility/create";
    }
}
