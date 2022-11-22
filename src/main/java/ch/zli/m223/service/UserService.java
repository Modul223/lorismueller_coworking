package ch.zli.m223.service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.User;

@ApplicationScoped
public class UserService {

  @Inject
  EntityManager entityManager;

  @Transactional
  public User createUser(User user) {
    return entityManager.merge(user);
  }

  public User getUser(Long id) {
    return entityManager.find(User.class, id);
  }

  @Transactional
  public User updateUser(Long id, User user) {
    user.setId(id);
    return entityManager.merge(user);
  }

  @Transactional
  public void deleteUser(Long id) {
    var entity = entityManager.find(User.class, id);
    entityManager.remove(entity);
  }

  public Optional<User> findWithEmail(String email) {
    return entityManager
        .createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
        .setParameter("email", email)
        .getResultStream()
        .findFirst();
  }

}
