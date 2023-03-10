package com._2lazy2name.notion.entity.common.filter.typeSpecific;

import com._2lazy2name.notion.enumeration.type.PropertyTypeEnum;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;

public class FilesFilter extends PropertyFilter {
    private final PropertyTypeEnum type = PropertyTypeEnum.FILES;
    private FilesFilterMethodEnum method;

    public FilesFilter(String property, FilesFilterMethodEnum method, Object value) {
        this.property = property;
        this.method = method;
        this.value = value;
    }

    public FilesFilter on(String property) {
        this.property = property;
        return this;
    }

    public FilesFilter isEmpty() {
        this.method = FilesFilterMethodEnum.IS_EMPTY;
        this.value = null;
        return this;
    }

    public FilesFilter isNotEmpty() {
        this.method = FilesFilterMethodEnum.IS_NOT_EMPTY;
        this.value = null;
        return this;
    }

    public enum FilesFilterMethodEnum implements IFilterMethod {
        IS_EMPTY("is_empty", BOOLEAN_ONLY_TRUE),
        IS_NOT_EMPTY("is_not_empty", BOOLEAN_ONLY_TRUE);

        private final String method;
        private final int valueType;

        FilesFilterMethodEnum(String method, int valueType) {
            this.method = method;
            this.valueType = valueType;
        }

        @Override
        public String getMethod() {
            return method;
        }

        @Override
        public int getValueType() {
            return valueType;
        }
    }

    public FilesFilter() {
    }

    @Override
    public PropertyTypeEnum getType() {
        return type;
    }

    @Override
    public FilesFilterMethodEnum getMethod() {
        return method;
    }

    public FilesFilter setMethod(FilesFilterMethodEnum method) {
        this.method = method;
        return this;
    }
}
