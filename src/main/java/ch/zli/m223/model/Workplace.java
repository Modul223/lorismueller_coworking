package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Workplace {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private int floor;

  @Column(nullable = false)
  private int table;

  @OneToMany(mappedBy = "workplace")
  @JsonIgnoreProperties("workplace")
  @Fetch(FetchMode.JOIN)
  private Set<Booking> bookings;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getFloor() {
    return floor;
  }

  public void setFloor(int floor) {
    this.floor = floor;
  }

  public int getTable() {
    return table;
  }

  public void setTable(int table) {
    this.table = table;
  }

  public Set<Booking> getBookings() {
    return bookings;
  }

  public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
  }

}