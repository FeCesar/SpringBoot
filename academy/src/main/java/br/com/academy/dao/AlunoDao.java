package br.com.academy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.academy.model.Aluno;

public interface AlunoDao extends JpaRepository<Aluno, Integer>{
    
    @Query("SELECT p FROM Aluno p WHERE p.status = 'ATIVO' ")
    public List<Aluno> findByStatusAtivo();

    @Query("SELECT p FROM Aluno p WHERE p.status = 'INATIVO' ")
    public List<Aluno> findByStatusInativo();

    @Query("SELECT p FROM Aluno p WHERE p.status = 'TRANCADO' ")
    public List<Aluno> findByStatusTrancado();

    @Query("SELECT p FROM Aluno p WHERE p.status = 'CANCELADO' ")
    public List<Aluno> findByStatusCancelado();

    public List<Aluno> findByNomeContainingIgnoreCase(String nome);

}
