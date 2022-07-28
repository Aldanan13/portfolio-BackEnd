
package com.portfolio.portfolioAldana.Repository;


import com.portfolio.portfolioAldana.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreEduc(String nombreEduc);
    public boolean existsByNombreEduc(String nombreEduc);
    
}
