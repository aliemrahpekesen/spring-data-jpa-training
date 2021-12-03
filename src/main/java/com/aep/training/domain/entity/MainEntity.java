package com.aep.training.domain.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class MainEntity {
    public MainEntity() {
    }

    private String name;
    private String testColumn;

    public MainEntity(String name, String testColumn) {
        this.name = name;
        this.testColumn = testColumn;
    }
}
