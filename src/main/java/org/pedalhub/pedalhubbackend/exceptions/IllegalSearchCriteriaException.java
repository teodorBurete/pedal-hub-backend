package org.pedalhub.pedalhubbackend.exceptions;

import org.pedalhub.pedalhubbackend.entities.advanced_search.SearchCriteria;

public class IllegalSearchCriteriaException extends RuntimeException {

    private final SearchCriteria searchCriteria;

    public IllegalSearchCriteriaException(String s, SearchCriteria searchCriteria) {
        super(s);
        this.searchCriteria = searchCriteria;
    }

    public SearchCriteria getSearchCriteria(){
        return this.searchCriteria;
    }
}
