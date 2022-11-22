package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private String firstname;

  @Column(nullable = false)
  private String lastname;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;  

  @ManyToOne(optional = false)
  @JsonIgnoreProperties("user")
  @Fetch(FetchMode.JOIN)
  private Role role;

  @OneToMany(mappedBy = "user")
  @JsonIgnoreProperties("user")
  @Fetch(FetchMode.JOIN)
  private Set<Report> reports;

  @OneToMany(mappedBy = "user")
  @JsonIgnoreProperties("user")
  @Fetch(FetchMode.JOIN)
  private Set<Booking> bookings;
  

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Set<Report> getReports() {
    return reports;
  }

  public void setReports(Set<Report> reports) {
    this.reports = reports;
  }

  public Set<Booking> getBookings() {
    return bookings;
  }

  public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
  }

}