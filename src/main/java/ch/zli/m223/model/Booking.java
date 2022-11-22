package ch.zli.m223.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

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

  @Column(nullable = false)
  private boolean bookingForWorkplace;

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

  public boolean isBookingForWorkplace() {
    return bookingForWorkplace;
  }

  public void setBookingForWorkplace(boolean bookingForWorkplace) {
    this.bookingForWorkplace = bookingForWorkplace;
  }




}