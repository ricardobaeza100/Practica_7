package com.mycompany.restaurante;

import web.Mensajes;
import javax.inject.Named;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;


/** Controlador que se utiliza en varias vistas. La anotación
 * <code>@ViewScoped</code> indica que los objetos se mantienen almacenados en
 * el archivo de sesión mientras se muestre la vista que está usando este bean.
 * Al cambiar de vista, los datos se pierden. */
@Named
@ViewScoped
public class CtrlRestauranteNuevo implements Serializable {
  private static final long serialVersionUID = 1L;
  @Inject
  private Mensajes mensajes;
  @Inject
  private DaoRestaurante dao;
  private Restaurante modelo;
  @PostConstruct
  void init() {
    modelo = new Restaurante();
  }
  public Restaurante getModelo() {
    return modelo;
  }
  /** Guarda los datos captuados y redirecciona el navegador a la página
   * "index". El query "?faces-redirect=true" hace que el navegador elimine de
   * su historia la página actual (en este caso la que manda guardar) y sea
   * sustituida por la página index. Prueba que sucede cuando el valor devuelto
   * solo es "index" y después de dar de alta un registro, recargas la página
   * varias veces. */
  public String guarda() {
    try {
      dao.agrega(modelo);
      return "index?faces-redirect=true";
    } catch (Exception ex) {
      mensajes.procesa(ex);
      return null;
    }
  }
}
