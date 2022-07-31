
package com.portfolio.portfolioAldana.Service;

import com.portfolio.portfolioAldana.Entity.Skills;
import com.portfolio.portfolioAldana.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServSkills {
    @Autowired
    RSkills rSkills;
    
    public List<Skills> list(){
        return rSkills.findAll();        
    }
    
    public Optional<Skills> getOne(int id){
        return rSkills.findById(id);
    }
    
    public Optional<Skills> getByNombreS(String nombreS){
        return rSkills.findByNombreS(nombreS);
    }
    
    public void save(Skills skill){
        rSkills.save(skill);
    }
    
    public void delete(int id){
        rSkills.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkills.existsById(id);
    }    
    
    public boolean existsByNombreS(String nombreS){
        return rSkills.existsByNombreS(nombreS);
    }
    
}

