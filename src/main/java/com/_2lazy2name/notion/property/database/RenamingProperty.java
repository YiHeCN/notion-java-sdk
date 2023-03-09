package com._2lazy2name.notion.property.database;

public class RenamingProperty extends AbstractDatabaseProperty {
    private String name;

    public String getName() {
        return name;
    }

    private RenamingProperty() {
    }

    public RenamingProperty(String name) {
        this.name = name;
    }
}
