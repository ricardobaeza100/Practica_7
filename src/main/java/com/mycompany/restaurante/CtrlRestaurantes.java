package com.mycompany.restaurante;

import web.Mensajes;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class CtrlRestaurantes {
  @Inject
  private Mensajes mensajes;
  @Inject
  private DaoRestaurante dao;
  private List<Restaurante> instancias;
  /* @PostConstruct indica que el método se ejecuta después de crear el objeto y
   * realizar todos los inject. Funciona casi como un constructor. */
  @PostConstruct
  void init() {
    try {
      instancias = dao.consulta();
    } catch (Exception ex) {
      mensajes.procesa(ex);
    }
  }
  public List<Restaurante> getInstancias() {
    return instancias;
  }
}
