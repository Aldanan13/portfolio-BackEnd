
package com.portfolio.portfolioAldana.Security.Repository;

import com.portfolio.portfolioAldana.Security.Entity.Rol;
import com.portfolio.portfolioAldana.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol>findByRolNombre(RolNombre rolNombre);
}
