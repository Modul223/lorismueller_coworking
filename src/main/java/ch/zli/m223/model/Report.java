package ch.zli.m223.model;

import java.util.Date;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Report {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private String message;

  @Column(nullable = false)
  private Date date;

  @ManyToOne(optional = false)
  @Fetch(FetchMode.JOIN)
  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
  
}