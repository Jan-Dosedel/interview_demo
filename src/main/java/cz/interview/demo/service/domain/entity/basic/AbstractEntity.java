package cz.interview.demo.service.domain.entity.basic;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Ancestor for all basic entities in the application.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "sys_attributes_id", referencedColumnName = "id")
  private SystemAttributes sys;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SystemAttributes getSys() {
    return sys;
  }

  public void setSys(SystemAttributes sys) {
    this.sys = sys;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractEntity that = (AbstractEntity) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(sys, that.sys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sys);
  }

  @Override
  public String toString() {
    return "AbstractEntity{" +
        "id=" + id +
        ", sys=" + sys +
        '}';
  }
}