package com._2lazy2name.notion.serializer;

import com._2lazy2name.notion.entity.common.filter.AbstractFilter;
import com._2lazy2name.notion.entity.common.filter.PropertyFilter;
import com._2lazy2name.notion.entity.common.filter.TimestampFilter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import static com._2lazy2name.notion.entity.common.filter.typeSpecific.IFilterMethod.*;

import java.io.IOException;

public class FilterSerializer extends StdSerializer<AbstractFilter> {

    protected FilterSerializer() {
        super(AbstractFilter.class);
    }

    protected FilterSerializer(Class<AbstractFilter> t) {
        super(t);
    }

    @Override
    public void serialize(AbstractFilter val, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (val instanceof PropertyFilter) {
            processPropertyFilter(val, gen, provider);
        }

        if (val instanceof TimestampFilter) {
            processTimestampFilter(val, gen, provider);
        }
    }

    public static String wrapInFilterObject(String filter) {
        return String.format("\"filter\": %s", filter);
    }

    private static void processTimestampFilter(AbstractFilter val, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        TimestampFilter filter = (TimestampFilter) val;
        gen.writeStringField("timestamp", filter.getTimestamp().toString());
        gen.writeObjectFieldStart(filter.getTimestamp().toString());
        switch (filter.getMethod().getValueType()) {
            case EMPTY_OBJECT -> {
                gen.writeObjectFieldStart(filter.getMethod().getMethod());
                gen.writeEndObject();
            }
            case DATE -> gen.writeObjectField(filter.getMethod().getMethod(), filter.getValue());
            case BOOLEAN_ONLY_TRUE -> gen.writeBooleanField(filter.getMethod().getMethod(), true);
        }
        gen.writeEndObject();
        gen.writeEndObject();
    }

    private static void processPropertyFilter(AbstractFilter val, JsonGenerator gen, SerializerProvider provider) throws IOException {
        PropertyFilter filter = (PropertyFilter) val;
        String propertyName = filter.getProperty();
        String type = filter.getType().toString();
        String method = filter.getMethod().getMethod();
        int valueType = filter.getMethod().getValueType();
        Object value = filter.getValue();

        gen.writeStartObject();
        gen.writeStringField("property", propertyName);
        gen.writeObjectFieldStart(type);
        switch (valueType) {
            case EMPTY_OBJECT -> {
                gen.writeObjectFieldStart(method);
                gen.writeEndObject();
            }
            case DATE -> gen.writeObjectField(method, value);
            case BOOLEAN -> gen.writeBooleanField(method, (Boolean) value);
            case BOOLEAN_ONLY_TRUE -> gen.writeBooleanField(method, true);
            case STRING -> gen.writeStringField(method, (String) value);
            case NUMBER -> gen.writeNumberField(method, (Float) value);
            case FILTER_OBJECT -> {
                PropertyFilter _value = (PropertyFilter) value;
                switch (method) {
                    case "number" -> {
                        gen.writeObjectFieldStart(method);
                        gen.writeNumberField(_value.getMethod().getMethod(), (Float) _value.getValue());
                    }
                    case "date" -> {
                        gen.writeObjectFieldStart(method);
                        gen.writeObjectField(_value.getMethod().getMethod(), _value.getValue());
                    }
                    case "checkbox" -> {
                        gen.writeObjectFieldStart(method);
                        gen.writeBooleanField(_value.getMethod().getMethod(), (Boolean) _value.getValue());
                    }
                    case "string" -> {
                        gen.writeObjectFieldStart(method);
                        gen.writeStringField(_value.getMethod().getMethod(), (String) _value.getValue());
                    }
                    case "any", "every", "none" -> {
                        gen.writeObjectFieldStart(method);
                        gen.writeObjectFieldStart(_value.getType().toString());
                        gen.writeObjectField(_value.getMethod().getMethod(), _value.getValue());
                        gen.writeEndObject();
                        gen.writeEndObject();
                    }
                }
            }
        }
        gen.writeEndObject();
    }
}
