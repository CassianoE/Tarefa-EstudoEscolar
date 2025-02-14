package app.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "O nome não pode estar vazio")
    @Pattern(regexp = "^\\p{L}+\\s+\\p{L}.+$", message = "O nome deve conter pelo menos duas palavras separadas por um espaço")
    private String nome;
    @CPF(message = "CPF inválido")
    private String cpf;
    private String telefone;

    // Relacionamento ManyToOne: um aluno está em uma turma
    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = false)  // A coluna "turma_id" será a chave estrangeira
    private Turma turma;



}
