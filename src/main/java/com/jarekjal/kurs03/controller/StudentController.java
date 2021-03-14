package com.jarekjal.kurs03.controller;

import com.jarekjal.kurs03.model.Student;
import com.jarekjal.kurs03.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> readAll() {
        return studentRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody @Valid Student source) {
        return studentRepository.save(source);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> readStudent(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody @Valid Student source, @PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(source.getFirstName());
                    student.setLastName(source.getLastName());
                    student.setEmail(source.getEmail());
                    studentRepository.save(student);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchStudent(@RequestBody Student source, @PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    if (source.getFirstName() != null) {
                        student.setFirstName(source.getFirstName());
                    }
                    if (source.getLastName() != null) {
                        student.setLastName(source.getLastName());
                    }
                    if (source.getEmail() != null) {
                        student.setEmail(source.getEmail());
                    }
                    studentRepository.save(student);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
