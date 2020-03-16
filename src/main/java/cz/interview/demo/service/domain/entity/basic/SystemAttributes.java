package cz.interview.demo.service.domain.entity.basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Managed POJO bean for store system attributes.
 */
@Entity
@Table(name = "sys_attributes")
@JsonIgnoreProperties(value = { "id" })
public class SystemAttributes implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Basic
  @Column(name="created_at")
  @NotNull
  private Timestamp cts;

  @Basic
  @Column(name="modified_at")
  private Timestamp mts;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Timestamp getCts() {
    return cts;
  }

  public void setCts(Timestamp cts) {
    this.cts = cts;
  }

  public Timestamp getMts() {
    return mts;
  }

  public void setMts(Timestamp mts) {
    this.mts = mts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemAttributes that = (SystemAttributes) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(cts, that.cts) &&
        Objects.equals(mts, that.mts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cts, mts);
  }

  @Override
  public String toString() {
    return "SystemAttributes{" +
        "id=" + id +
        ", cts=" + cts +
        ", mts=" + mts +
        '}';
  }
}