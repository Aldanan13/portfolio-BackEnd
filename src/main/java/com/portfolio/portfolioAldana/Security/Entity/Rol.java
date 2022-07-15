
package com.portfolio.portfolioAldana.Security.Entity;

import com.portfolio.portfolioAldana.Security.Enums.RolNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNom;

    public Rol() {
    }

    public Rol(RolNombre rolNom) {
        this.rolNom = rolNom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNom() {
        return rolNom;
    }

    public void setRolNom(RolNombre rolNom) {
        this.rolNom = rolNom;
    }
    
    

}
    
