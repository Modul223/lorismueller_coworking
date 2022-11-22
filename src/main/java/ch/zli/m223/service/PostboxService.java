package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.PostOfficeBox;

@ApplicationScoped
public class PostboxService {

  @Inject
  EntityManager entityManager;

  @Transactional
  public PostOfficeBox createPostbox(PostOfficeBox postbox) {
    return entityManager.merge(postbox);
  }

  public List<PostOfficeBox> findPostOfficeBoxes() {
    var query = entityManager.createQuery("FROM PostOfficeBox", PostOfficeBox.class);
    return query.getResultList();
  }

}
