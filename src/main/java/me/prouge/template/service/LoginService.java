package me.prouge.template.service;

import com.google.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.prouge.template.entities.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginService {

    @Inject
    private EntityManager entityManager;
    private static final Logger logger = LogManager.getLogger();

    public boolean login(final String email, final String pwd) {
        TypedQuery<UserEntity> typedQuery
                = entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.email=:email AND u.password=:pwd", UserEntity.class);
        typedQuery.setParameter("email", email);
        typedQuery.setParameter("pwd", pwd);

        return typedQuery.getResultList().size() == 1;
    }

    public void register(final String email, final String pwd) {
        entityManager.getTransaction().begin();
        entityManager.persist(new UserEntity(email, pwd));

        // logger.error("FEHLER");
    }

}
