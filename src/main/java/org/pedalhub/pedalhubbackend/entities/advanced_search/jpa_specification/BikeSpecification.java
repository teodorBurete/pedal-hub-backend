package org.pedalhub.pedalhubbackend.entities.advanced_search.jpa_specification;

import jakarta.persistence.criteria.*;
import org.pedalhub.pedalhubbackend.entities.Bike;
import org.pedalhub.pedalhubbackend.entities.Brand;
import org.pedalhub.pedalhubbackend.entities.Category;
import org.pedalhub.pedalhubbackend.entities.advanced_search.SearchCriteria;
import org.pedalhub.pedalhubbackend.exceptions.IllegalSearchCriteriaException;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BikeSpecification implements Specification<Bike> {

    private SearchCriteria searchCriteria;

    public BikeSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Bike> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        String key = searchCriteria.getFilterKey().toLowerCase();
        String operation = searchCriteria.getOperation().toLowerCase();

        if (operation.equals("eq")) {
            String valueToSearch = searchCriteria.getValue().toString().toLowerCase();

            if (key.equals("brand")) return cb.equal(cb.lower(brandJoin(root).get("name")), valueToSearch);
            if (key.equals("category")) return cb.equal(cb.lower(categoryJoin(root).get("name")), valueToSearch);
            if (key.equals("framematerial")) return cb.equal(cb.lower(root.get("frameMaterial")), valueToSearch);
            if (key.equals("brakestype")) return cb.equal(cb.lower(root.get("brakesType")), valueToSearch);
            if (key.equals("year")) return cb.equal(root.get("year"), valueToSearch);
            // if(key.equals("price")) return cb.equal(cb.lower(root.get("suspensionType")), valueToSearch);
        }

        if (operation.equals("in")) {

            if(key.equals("brakestype")){
                List<String> valuesToSearch;
                try {
                    valuesToSearch = (ArrayList<String>) searchCriteria.getValue();
                    return cb.lower(root.get("brakesType")).in(valuesToSearch);
                } catch (Exception e) {
                    throw new IllegalSearchCriteriaException("values not allowed", searchCriteria);
                }
            }

            if(key.equals("framematerial")){
                List<String> valuesToSearch;
                try {
                    valuesToSearch = (ArrayList<String>) searchCriteria.getValue();
                    return cb.lower(root.get("frameMaterial")).in(valuesToSearch);
                } catch (Exception e) {
                    throw new IllegalSearchCriteriaException("values not allowed", searchCriteria);
                }
            }
            if (key.equals("brand")) {
                List<String> valuesToSearch;
                try {
                    valuesToSearch = (ArrayList<String>) searchCriteria.getValue();
                    return cb.lower(brandJoin(root).get("name")).in(valuesToSearch);
                } catch (Exception e) {
                    throw new IllegalSearchCriteriaException("values not allowed", searchCriteria);
                }
            }

            if (key.equals("year")) {
                List<Integer> valuesToSearch;
                try {
                    valuesToSearch = (ArrayList<Integer>) searchCriteria.getValue();
                    return root.get("year").in(valuesToSearch);
                } catch (Exception e) {
                    throw new IllegalSearchCriteriaException("values not allowed", searchCriteria);

                }
            }
            if (key.equals("category")) {
                List<String> valuesToSearch;
                try {
                    valuesToSearch = (ArrayList<String>) searchCriteria.getValue();
                    return cb.lower(categoryJoin(root).get("name")).in(valuesToSearch);
                } catch (Exception e) {
                    throw new IllegalSearchCriteriaException("values not allowed", searchCriteria);

                }
            }
        }

        if (operation.equals("le")) {
            if (key.equals("price"))
                return cb.le(root.get("price"), Double.valueOf(searchCriteria.getValue().toString()));
        }

        if (operation.equals("ge")) {
            if (key.equals("price"))
                return cb.ge(root.get("price"), Double.valueOf(searchCriteria.getValue().toString()));
        }

        throw new IllegalSearchCriteriaException("filterKey not allowed", searchCriteria);
    }

    private Join<Bike, Category> categoryJoin(Root<Bike> root) {
        return root.join("category");
    }

    private Join<Bike, Brand> brandJoin(Root<Bike> root) {
        return root.join("brand");
    }
}
