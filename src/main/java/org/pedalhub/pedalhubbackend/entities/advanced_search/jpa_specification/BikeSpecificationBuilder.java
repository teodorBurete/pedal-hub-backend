package org.pedalhub.pedalhubbackend.entities.advanced_search.jpa_specification;

import org.pedalhub.pedalhubbackend.entities.Bike;
import org.pedalhub.pedalhubbackend.entities.advanced_search.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BikeSpecificationBuilder {

    private List<SearchCriteria> params;

    public BikeSpecificationBuilder() {
        this.params = new ArrayList<>();
    }

    public final BikeSpecificationBuilder with(SearchCriteria searchCriteria) {
        params.add(searchCriteria);
        return this;
    }

    public Specification<Bike> build() {
        if (params.size() == 0) {
            return null;
        }

        Specification<Bike> result =
                new BikeSpecification(params.get(0));
        for (int idx = 1; idx < params.size(); idx++) {
            SearchCriteria criteria = params.get(idx);
            result = criteria.getDataOption().equals("all")
                    ? Specification.where(result).and(
                    new BikeSpecification(criteria))
                    : Specification.where(result).or(
                    new BikeSpecification(criteria));
        }
        return result;
    }

}
