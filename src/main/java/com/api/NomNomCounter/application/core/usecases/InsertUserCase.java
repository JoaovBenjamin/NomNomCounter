package com.api.NomNomCounter.application.core.usecases;

import com.api.NomNomCounter.application.core.domain.user.User;
import com.api.NomNomCounter.application.ports.in.InsertUserInputPort;
import com.api.NomNomCounter.application.ports.out.user.InsertUserOutPort;

public class InsertUserCase implements InsertUserInputPort{

    private final InsertUserOutPort insertUserOutPort;
    public InsertUserCase(InsertUserOutPort insertUserOutPort){
        this.insertUserOutPort = insertUserOutPort;
    }
    @Override
    public void execute(User user) throws Exception {
        insertUserOutPort.save(user);
    }
}
