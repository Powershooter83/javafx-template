package me.prouge.template.service;

import com.google.inject.Inject;
import me.prouge.guicefx.persistence.DatabaseManager;
import me.prouge.template.entities.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LoginService {

    @Inject
    private DatabaseManager databaseManager;
    private static final Logger logger = LogManager.getLogger();

    public boolean login(final String email, final String pwd) {
        List<UserEntity> users = databaseManager.executeQueryWithResultList("SELECT u FROM UserEntity u WHERE u.email=:email AND u.password=:pwd", UserEntity.class, q -> {
            q.setParameter("email", email);
            q.setParameter("pwd", pwd);
        });

        return users.size() == 1;
    }

    public void register(final String email, final String pwd) {
        databaseManager.runInTransaction(e -> e.persist(new UserEntity(email, pwd)));
        // logger.error("FEHLER");
    }

}
