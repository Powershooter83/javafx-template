package me.prouge.template.services;

import me.prouge.template.entities.UserEntity;
import me.prouge.template.utils.Model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LoginService {

    private static final Logger logger = LogManager.getLogger();

    public boolean login(final String email, final String pwd) {
        List<UserEntity> users = Model.getInstance().getDatabaseManager().executeQueryWithResultList("SELECT u FROM UserEntity u WHERE u.email=:email AND u.password=:pwd",
                UserEntity.class, q -> {
                    q.setParameter("email", email);
                    q.setParameter("pwd", pwd);
                });
        return users.size() == 1;
    }

    public void register(final String email, final String pwd) {
        Model.getInstance().getDatabaseManager().runInTransaction(e -> e.persist(new UserEntity(email, pwd)));
        // logger.error("FEHLER");
    }

}
