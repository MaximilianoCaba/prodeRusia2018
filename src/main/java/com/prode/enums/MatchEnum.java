package com.prode.enums;

public enum MatchEnum {

    NOT_STARTED(1L, "NOT_STARTED"),
    IN_PROGRESS(2L, "IN_PROGRESS"),
    FINISHED(3L, "FINISHED");

    private Long idSqlSchema;
    private String state;

    MatchEnum(Long idSqlSchema, String state) {
        this.idSqlSchema = idSqlSchema;
        this.state = state;
    }


    public Long getIdSqlSchema() {
        return idSqlSchema;
    }

    public void setIdSqlSchema(Long idSqlSchema) {
        this.idSqlSchema = idSqlSchema;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
