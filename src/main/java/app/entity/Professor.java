package app.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode estar vazio")
    @Pattern(regexp = "^\\p{L}+\\s+\\p{L}.+$", message = "O nome deve conter pelo menos duas palavras separadas por um espaço")
    private String nome;
    @CPF(message = "CPF inválido")
    private String cpf;
    @NotBlank(message = "O e-mail não pode estar vazio")
    @Email(message = "E-mail inválido")
    private String email;
    @Pattern(
            regexp = "(^$|^\\S+\\s+\\S+$)",
            message = "A especialidade deve conter pelo menos duas palavras separadas por um espaço, se preenchida"
    )
    private String especialidade;

    // Relacionamento ManyToMany: um professor pode lecionar em várias turmas
    @ManyToMany(mappedBy = "professorList")  // mapeado pela lista de professores da Turma
    @JsonIgnoreProperties("professorList")
    private List<Turma> turmaList;
}
