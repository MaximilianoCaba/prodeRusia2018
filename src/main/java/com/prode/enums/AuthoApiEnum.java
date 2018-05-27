package com.prode.enums;

public enum AuthoApiEnum {

    ADMIN1(1L,"5c452476c420dd093b2fd0ff64d54b80", "maru");

    private Long userId;
    private String Hash;
    private String referencialName;

    AuthoApiEnum(Long userId, String hash, String referencialName) {
        this.userId = userId;
        Hash = hash;
        this.referencialName = referencialName;
    }

    public static boolean isAutheticathed(String hash){
        for (AuthoApiEnum authoApiEnum: AuthoApiEnum.values()){
            if(authoApiEnum.getHash().equals(hash))
                return true;
        }
        return false;
    }

    public String getHash() {
        return Hash;
    }

}
