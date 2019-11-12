package com.mycompany.restaurante;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** Clase conectada a la tabla Pasatiempo.
 * Esta clase se crea con los siguientes pasos:
 * <ol>
 * <li>Selecciona el paquete donde quieras colocar la clase .</li>
 * <li>Menú File > New File... </li>
 * <li>
 * Categories: Persistence, File Types: Entity Class, Next>.
 * </li>
 * <li>
 * Class Name: Pasatiempo, Package: net.ramptors.pasa Primary Key Type: Integer.
 * </li>
 * <li>Clic en Finish.</li>
 * </ol>
 * <p>
 * <code>Serializable</code> indica que el objeto se puede almacenar y
 * recuperar.
 * </p> */
@Entity
@Table(name = "restaurante") // Tabla a la que está ligada esta Entity.
public class Restaurante implements Serializable {
  /** Constante que se utiliza cuando la clase es serializable. */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PAS_ID")
  private Integer id;
  // Las siguientes anotaciones se explican en el la página sobre Bean Validation.
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "PAS_NOMBRE")
  private String nombre;
  @NotNull
  @Size(min = 1, max = 255)
   @Column(name = "PAS_NOMBRE_RESTAURANTE")
   private String restaurante;

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }
   
   
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Restaurante)) {
      return false;
    }
    Restaurante other = (Restaurante) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.
        equals(other.id))) {
      return false;
    }
    return true;
  }
  @Override
  public String toString() {
    return "com.mycompany.restaurante.Restaurante[ id=" + id + " ]";
  }
}
