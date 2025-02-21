package app.controller;

import app.entity.Curso;
import app.entity.Professor;
import app.service.CursoService;
import app.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Professor professor){
        try {
            String mensagem = this.professorService.save(professor);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id){
        try {
            Professor professor = this.professorService.findById(id);
            return new ResponseEntity<>(professor,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Professor>> findAll(){
        try {
            List<Professor> professorList = this.professorService.findAll();
            return new ResponseEntity<>(professorList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Professor professor, @PathVariable Long id){
        try {
            String  mensagem = this.professorService.update(professor, id);
            return new ResponseEntity<>(mensagem,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();  // Isso ajuda a ver o erro no log
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            String  mensagem = this.professorService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByNomeOrEspecialidade")
    public ResponseEntity<List<Professor>> findByComecoNomeOuEspecialidade(@RequestParam String nome, @RequestParam String especialidade) {
        try {
            List<Professor> professorList = this.professorService.findProfessorsByComecoNomeOrEspecialidade(nome, especialidade);
            return new ResponseEntity<>(professorList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByWithoutGmail")
    public ResponseEntity<List<Professor>> findByWithoutGmail() {
        try {
            List<Professor> professorList = this.professorService.findByWithoutGmail();
            return new ResponseEntity<>(professorList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<Professor> findByEmail(@RequestParam String email) {
        try {
            Professor professor = this.professorService.findByEmail(email);
            return new ResponseEntity<>(professor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
