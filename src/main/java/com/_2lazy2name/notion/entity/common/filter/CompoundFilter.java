package com._2lazy2name.notion.entity.common.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import java.util.List;

@JsonSerialize()
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompoundFilter implements AbstractFilter {
    private List<AbstractFilter> or;
    private List<AbstractFilter> and;

    public List<AbstractFilter> getOr() {
        return or;
    }

    public CompoundFilter setOr(List<AbstractFilter> or) {
        this.or = or;
        return this;
    }

    public List<AbstractFilter> getAnd() {
        return and;
    }

    public CompoundFilter setAnd(List<AbstractFilter> and) {
        this.and = and;
        return this;
    }
}
