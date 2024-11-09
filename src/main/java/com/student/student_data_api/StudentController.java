package com.student.student_data_api;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.List;
import com.student.student_data_api.StudentService;



@RestController
@RequestMapping("students")
@Validated
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(@RequestParam(required = false) String course,
                                        @RequestParam(required = false) Boolean feesPaid) {
        return studentService.getAllStudents(course, feesPaid);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student addStudent(@RequestBody @Valid Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody @Valid Student student) {
        return studentService.getStudentById(id)
                .map(existingStudent -> ResponseEntity.ok(studentService.updateStudent(id, student)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/top")
    public List<Student> getTopRankers(@RequestParam int n) {
        return studentService.getTopRankers(n);
    }

    @GetMapping("/marks-range")
    public List<Student> getStudentsByMarksRange(@RequestParam double minMarks, @RequestParam double maxMarks) {
        return studentService.getStudentsByMarksRange(minMarks, maxMarks);
    }

    // Endpoint to filter students by course
    @GetMapping("/filter-by-course")
    public List<Student> getStudentsByCourse(@RequestParam String course) {
        return studentService.getStudentsByCourse(course);
    }

    // Endpoint to filter students by feesPaid status
    @GetMapping("/filter-by-fees")
    public List<Student> getStudentsByFeesPaidStatus(@RequestParam boolean feesPaid) {
        return studentService.getStudentsByFeesPaidStatus(feesPaid);
    }

    @GetMapping("/students/sorted")
    public List<Student> getAllStudentsSorted(@RequestParam(required = false) String sortBy) {
        return studentService.getAllStudentsSorted(sortBy);
    }

    @GetMapping("/students/filtered")
    public List<Student> getFilteredStudents(
            @RequestParam(required = false) String course,
            @RequestParam(required = false) Boolean feesPaid,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge) {
        return studentService.getFilteredStudents(course, feesPaid, minAge, maxAge);
}
}