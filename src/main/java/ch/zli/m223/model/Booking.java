package ch.zli.m223.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime start;

  @Column(nullable = false)
  private LocalDateTime end;

  @ManyToOne(optional = false)
  @Fetch(FetchMode.JOIN)
  private User user;

  @ManyToOne(optional = true)
  @Fetch(FetchMode.JOIN)
  private Workplace workplace;

  @ManyToOne(optional = true)
  @Fetch(FetchMode.JOIN)
  private PostOfficeBox postOfficeBox;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getStart() {
    return start;
  }

  public void setStart(LocalDateTime start) {
    this.start = start;
  }

  public LocalDateTime getEnd() {
    return end;
  }

  public void setEnd(LocalDateTime end) {
    this.end = end;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Workplace getWorkplace() {
    return workplace;
  }

  public void setWorkplace(Workplace workplace) {
    this.workplace = workplace;
  }

  public PostOfficeBox getPostOfficeBox() {
    return postOfficeBox;
  }

  public void setPostOfficeBox(PostOfficeBox postOfficeBox) {
    this.postOfficeBox = postOfficeBox;
  }

  

}