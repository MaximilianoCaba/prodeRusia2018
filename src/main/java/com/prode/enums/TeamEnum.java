package com.prode.enums;

public enum TeamEnum {

    Russia(1L),
    SaudiArabia(2L),
    Egypt(3L),
    Uruguay(4L),
    Portugal(5L),
    Spain(6L),
    Morocco(7L),
    Iran(8L),
    France(9L),
    Australia(10L),
    Peru(11L),
    Denmark(12L),
    Argentina(13L),
    Iceland(14L),
    Croatia(15L),
    Nigeria(16L),
    Brazil(17L),
    Switzerland(18L),
    CostaRica(19L),
    Serbia(20L),
    Germany(21L),
    Mexico(22L),
    Sweden(23L),
    SouthKorea(24L),
    Belgium(25L),
    Panama(26L),
    Tunisia(27L),
    England(28L),
    Poland(29L),
    Senegal(30L),
    Colombia(31L),
    Japan(32L);

    private Long sqlId;

    TeamEnum(Long sqlId) {
        this.sqlId = sqlId;
    }

    public Long getSqlId() {
        return sqlId;
    }

    public void setSqlId(Long sqlId) {
        this.sqlId = sqlId;
    }
}
