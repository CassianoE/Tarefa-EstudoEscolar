package app.repository;

import app.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository  extends JpaRepository<Curso, Long> {

    List<Curso> findByNomeIgnoreCase(String nome);
}
