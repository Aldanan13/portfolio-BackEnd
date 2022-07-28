

package com.portfolio.portfolioAldana.Service;

import com.portfolio.portfolioAldana.Entity.Educacion;
import com.portfolio.portfolioAldana.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServEducacion {
    @Autowired
     REducacion rEducacion;
     
     public List<Educacion> list(){
         return rEducacion.findAll();
     }
     
     public Optional<Educacion> getOne(int id){
         return rEducacion.findById(id);
     }
     
     public Optional<Educacion> getByNombreEduc(String nombreEduc){
         return rEducacion.findByNombreEduc(nombreEduc);
     }
     
     public void save(Educacion educ){
         rEducacion.save(educ);
     }
     
     public void delete(int id){
         rEducacion.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rEducacion.existsById(id);
     }
     
     public boolean existsByNombreEduc(String nombreEduc){
         return rEducacion.existsByNombreEduc(nombreEduc);
     }
}



