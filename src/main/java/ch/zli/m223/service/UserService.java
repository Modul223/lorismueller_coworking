package ch.zli.m223.service;

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
  public User createUser(User user){
    return entityManager.merge(user);
  }

  
}
