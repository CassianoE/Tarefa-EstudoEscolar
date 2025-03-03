package app.controller;

import app.entity.Curso;
import app.entity.Turma;
import app.service.CursoService;
import app.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Turma turma){
        try {
            String mensagem = this.turmaService.save(turma);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Long id){
        try {
            Turma turma = this.turmaService.findById(id);
            return new ResponseEntity<>(turma,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Turma>> findAll(){
        try {
            List<Turma> turmaList = this.turmaService.findAll();
            return new ResponseEntity<>(turmaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Turma turma, @PathVariable Long id){
        try {
            String  mensagem = this.turmaService.update(turma, id);
            return new ResponseEntity<>(mensagem,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            String  mensagem = this.turmaService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByanoBetween")
    public ResponseEntity<List<Turma>> findByAnoBetween(@RequestParam int anoInicio, @RequestParam int anoFim) {
        try {
            List<Turma> turmaList = this.turmaService.findTurmasByAnoBetween(anoInicio, anoFim);
            return new ResponseEntity<>(turmaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findBysemestreAndAno")
    public ResponseEntity<List<Turma>> findBySemestreAndAno(@RequestParam String semestre, @RequestParam int ano) {
        try {
            List<Turma> turmaList = this.turmaService.findTurmasBySemestreAndAno(semestre, ano);
            return new ResponseEntity<>(turmaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findBynomeAndTurno")
    public ResponseEntity<List<Turma>> findByNomeAndTurno(@RequestParam String nome, @RequestParam String turno) {
        try {
            List<Turma> turmaList = this.turmaService.findTurmasByNomeAndTurno(nome, turno);
            return new ResponseEntity<>(turmaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByCurso")
    public ResponseEntity<List<Turma>> findByCurso(@RequestParam String nomeCurso) {
        try {
            List<Turma> turmaList = this.turmaService.findByCurso(nomeCurso);
            return new ResponseEntity<>(turmaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
