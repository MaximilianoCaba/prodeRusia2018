package com.prode.service;

import com.prode.entity.User;
import com.prode.request.PronosticResult;

import java.util.List;

public interface UserMatchService {

    public String  savePronosticResult(List<PronosticResult> pronosticResultList, User user);

}
