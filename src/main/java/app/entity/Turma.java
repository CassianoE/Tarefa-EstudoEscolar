package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String semestre;
    private int ano;
    private String turno;

    // Relacionamento OneToMany: uma turma pode ter muitos alunos
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<Aluno> alunoList;

    // Relacionamento ManyToMany: uma turma pode ter vários professores
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "turma_professor",  // Nome da tabela associativa
            joinColumns = @JoinColumn(name = "turma_id"),  // Chave estrangeira para Turma
            inverseJoinColumns = @JoinColumn(name = "professor_id")  // Chave estrangeira para Professor
    )
    @JsonIgnoreProperties("turmaList")
    private List<Professor> professorList;

    // Relacionamento ManyToOne: uma turma está associada a um único curso
    @ManyToOne
    @NotNull(message = "o curso e obrigatorio ao salvar uma turma")
    private Curso curso;  // Curso associado à turma
}
