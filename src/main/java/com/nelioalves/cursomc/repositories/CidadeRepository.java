package com.nelioalves.cursomc.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Cidade;

@Repository  //Essa interface vai herdar "extender" da interface JpaRepository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
}
