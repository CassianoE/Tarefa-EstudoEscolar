package app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
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
}
