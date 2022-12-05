package com.example.case_study.dto.facility;

import com.example.case_study.model.facility.FacilityType;
import com.example.case_study.model.facility.RentType;


public interface FacilityView {

    Long getId();

    String getName();

    int getAre();

    double getCost();

    int getMaxPeoPel();

    FacilityType getFacilityType();

    RentType getRentType();

    String getStandardRoom();

    String getDescriptionOtherConvenience();

    double getPoolArea();

    int getNumberOfFloors();

    String getFacilityFree();

}
