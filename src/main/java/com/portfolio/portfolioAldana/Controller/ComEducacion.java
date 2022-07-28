
package com.portfolio.portfolioAldana.Controller;

import com.portfolio.portfolioAldana.Dto.DtoEducacion;
import com.portfolio.portfolioAldana.Entity.Educacion;
import com.portfolio.portfolioAldana.Security.Controller.Mensaje;
import com.portfolio.portfolioAldana.Service.ServEducacion;
import java.util.List;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educ")
@CrossOrigin(origins = "http://localhost:4200")
public class ComEducacion {
    @Autowired
    ServEducacion servEducacion;
    
    @GetMapping("/lista")//TRAER LISTA
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = servEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!servEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = servEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
   
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!servEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        servEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Estudio eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")//CREAR LISTA
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoeduc){      
        if(StringUtils.isBlank(dtoeduc.getNombreEduc()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(servEducacion.existsByNombreEduc(dtoeduc.getNombreEduc()))
            return new ResponseEntity(new Mensaje("Ese estudio ya existe"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoeduc.getNombreEduc(), dtoeduc.getDescripcionEduc());
        servEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Estudio agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")//ACTUALIZAR 
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoeduc){
        //Validamos si existe el ID
        if(!servEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(servEducacion.existsByNombreEduc(dtoeduc.getNombreEduc()) && servEducacion.getByNombreEduc(dtoeduc.getNombreEduc()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese estudio ya existe"), HttpStatus.BAD_REQUEST);
        //El campo no puede estar vacio
        if(StringUtils.isBlank(dtoeduc.getNombreEduc()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = servEducacion.getOne(id).get();
        educacion.setNombreEduc(dtoeduc.getNombreEduc());
        educacion.setDescripcionEduc((dtoeduc.getDescripcionEduc()));
        
        servEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Estudio actualizado"), HttpStatus.OK);
             
    }
}



