package com.nelioalves.cursomc.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Estado;

@Repository  //Essa interface vai herdar "extender" da interface JpaRepository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
}
