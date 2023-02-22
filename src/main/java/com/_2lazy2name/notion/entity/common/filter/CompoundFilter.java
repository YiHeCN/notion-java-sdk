package com._2lazy2name.notion.entity.common.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
@JsonSerialize()
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompoundFilter implements AbstractFilter {
    private List<AbstractFilter> or;
    private List<AbstractFilter> and;
}
