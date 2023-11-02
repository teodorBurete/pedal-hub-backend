package org.pedalhub.pedalhubbackend.entities.advanced_search;

import java.util.List;

public class BikeSearchDto {

    private List<SearchCriteria> searchCriteriaList;
    private String dataOption;

    public BikeSearchDto() {
    }

    public List<SearchCriteria> getSearchCriteriaList() {
        return searchCriteriaList;
    }

    public BikeSearchDto(List<SearchCriteria> searchCriteriaList, String dataOption) {
        this.searchCriteriaList = searchCriteriaList;
        this.dataOption = dataOption;
    }

    public void setSearchCriteriaList(List<SearchCriteria> searchCriteriaList) {
        this.searchCriteriaList = searchCriteriaList;
    }

    public String getDataOption() {
        return dataOption;
    }

    public void setDataOption(String dataOption) {
        this.dataOption = dataOption;
    }
}
