package app.repository;

import app.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT p FROM Professor p WHERE p.nome LIKE :nome% OR p.especialidade LIKE :especialidade%")
    List<Professor> findByComecoNomeOuEspecialidade(@Param("nome") String nome, @Param("especialidade") String especialidade);

    List<Professor> findByEmailNotContaining(String dominio);

    Professor findByEmail(String email);


}
