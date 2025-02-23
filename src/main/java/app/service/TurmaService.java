package app.service;

import app.entity.Turma;
import app.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public String save(Turma turma){
        this.turmaRepository.save(turma);
        return "Turma salva com sucesso!";
    }

    public Turma findById(Long id){
        Turma turma = turmaRepository.findById(id).get();
        return turma;
    }

    public List<Turma> findAll() {
        List<Turma> turmaList = this.turmaRepository.findAll();
        return turmaList;
    }

    public String update(Turma turma, Long id){

        this.turmaRepository.save(turma);
        return "A Turma" + turma.getNome() +  " foi atualizado com sucesso!";
    }

    public String delete(Long id) {
        this.turmaRepository.deleteById(id);
        return "A Turma " + id + " foi excluído com sucesso!";
    }

    public List<Turma> findTurmasByAnoBetween(int anoInicio, int anoFim) {
        return this.turmaRepository.findByAnoBetween(anoInicio, anoFim);
    }

    public List<Turma> findTurmasBySemestreAndAno(String semestre, int ano) {
        return this.turmaRepository.findBySemestreAndAno(semestre, ano);
    }

    public List<Turma> findTurmasByNomeAndTurno(String nome, String turno) {
        return this.turmaRepository.findByNomeAndTurno(nome, turno);
    }

    public List<Turma> findByCurso (String nomeCurso) {
        return this.turmaRepository.findByCursoNome(nomeCurso);
    }
}
