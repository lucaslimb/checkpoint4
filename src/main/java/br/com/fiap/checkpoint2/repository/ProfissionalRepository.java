package br.com.fiap.checkpoint2.repository;

import br.com.fiap.checkpoint2.model.Profissionais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissionais, Long>{

}