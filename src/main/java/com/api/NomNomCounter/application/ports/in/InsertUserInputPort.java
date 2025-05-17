package com.api.NomNomCounter.application.ports.in;

import com.api.NomNomCounter.application.core.domain.user.User;

public interface InsertUserInputPort {
    void execute(User user) throws Exception;
}
