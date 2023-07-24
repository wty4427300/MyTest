package com.design_patterns.pipeline.v2.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author gim
 */
public class LocalListBasedFilterSelector implements FilterSelector {

    private List<String> filterNames = new ArrayList<>();

    public LocalListBasedFilterSelector(List<String> filterNames) {
        this.filterNames = filterNames;
    }

    @Override
    public boolean matchFilter(String classSimpleName) {
        //anyMatch表示流中是否有任何一个元素满足给定的条件
        return filterNames.stream().anyMatch(s -> Objects.equals(s, classSimpleName));
    }

    @Override
    public List<String> getFilterNames() {
        return filterNames;
    }

    public void addFilter(String clsNames) {
        filterNames.add(clsNames);
    }

    public void addFilters(List<String> filterName) {
        filterNames.addAll(filterName);
    }

    public LocalListBasedFilterSelector() {
    }
}
