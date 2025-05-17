package com.api.NomNomCounter.application.ports.out.user;

import com.api.NomNomCounter.application.core.domain.user.User;
public interface InsertUserOutPort {
    void save(User user) throws Exception;
}
