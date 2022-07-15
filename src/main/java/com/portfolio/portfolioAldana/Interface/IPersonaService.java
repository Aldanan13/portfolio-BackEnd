
package com.portfolio.portfolioAldana.Interface;

import com.portfolio.portfolioAldana.Entity.Persona;
import java.util.List;



public interface IPersonaService {
 //Traer Personas    
 public List<Persona> getPersona(); 
 
 //Guardar objeto de tipo Persona
 public void savePersona(Persona persona);
 
 //Eliminar objeto por id 
 public void deletePersona(Long id);
 
 //Buscar Persona por id 
 public Persona findPersona(Long id);
 
}
