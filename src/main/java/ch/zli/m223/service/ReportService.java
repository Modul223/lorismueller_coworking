package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Report;

@ApplicationScoped
public class ReportService {

  @Inject
  EntityManager entityManager;

  @Transactional
  public Report createReport(Report report) {
    return entityManager.merge(report);
  }

}
