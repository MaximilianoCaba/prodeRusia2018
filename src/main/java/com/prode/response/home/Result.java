package com.prode.response.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private List<UserResult> generalResult;
    private Map<Integer, List<UserResult>> roundResult;


    public Result() {
    }

    public List<UserResult> getGeneralResult() {
        return generalResult;
    }

    public void setGeneralResult(List<UserResult> generalResult) {
        this.generalResult = generalResult;
    }

    public Map<Integer, List<UserResult>> getRoundResult() {
       return (roundResult == null) ? new HashMap<>() : roundResult;
    }

    public void setRoundResult(Map<Integer, List<UserResult>> roundResult) {
        this.roundResult = roundResult;
    }
}
