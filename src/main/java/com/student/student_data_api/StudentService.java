package com.student.student_data_api;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map<Integer, Student> students = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    // Retrieve all students
    public List<Student> getAllStudents(String course, Boolean feesPaid) {
        return students.values().stream()
                .filter(student -> (course == null || student.getCourse().equalsIgnoreCase(course)) &&
                                   (feesPaid == null || student.getFeesPaid().equals(feesPaid)))
                .collect(Collectors.toList());
    }

    // Retrieve student by ID
    public Optional<Student> getStudentById(int id) {
        return Optional.ofNullable(students.get(id));
    }

    // Add a new student
    public Student addStudent(Student student) {
        int id = idCounter.getAndIncrement();
        student.setId(id);
        students.put(id, student);
        return student;
    }

    // Update student by ID
    public Student updateStudent(int id, Student student) {
        student.setId(id);
        students.put(id, student);
        return student;
    }

    // Delete student by ID
    public boolean deleteStudent(int id) {
        return students.remove(id) != null;
    }

    // Retrieve top n students by marks
    public List<Student> getTopRankers(int n) {
        return students.values().stream()
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByMarksRange(double minMarks, double maxMarks) {
        return students.values().stream()
                .filter(student -> student.getMarks() >= minMarks && student.getMarks() <= maxMarks)
                .collect(Collectors.toList());
    }

    // Method to filter students by course
    public List<Student> getStudentsByCourse(String course) {
        return students.values().stream()
            .filter(student -> student.getCourse().equalsIgnoreCase(course))
            .collect(Collectors.toList());
    }

    // Method to filter students by feesPaid status
    public List<Student> getStudentsByFeesPaidStatus(boolean feesPaid) {
        return students.values().stream()
                .filter(student -> student.getFeesPaid() == feesPaid)
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudentsSorted(String sortBy) {
        return students.values().stream()
                .sorted((student1, student2) -> {
                    switch (sortBy) {
                        case "name": return student1.getName().compareToIgnoreCase(student2.getName());
                        case "age": return student1.getAge().compareTo(student2.getAge());
                        case "marks": return student1.getMarks().compareTo(student2.getMarks());
                        default: return student1.getId().compareTo(student2.getId());
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Student> getFilteredStudents(String course, Boolean feesPaid, Integer minAge, Integer maxAge) {
        return students.values().stream()
                .filter(student -> (course == null || student.getCourse().equalsIgnoreCase(course)) &&
                                   (feesPaid == null || student.getFeesPaid().equals(feesPaid)) &&
                                   (minAge == null || student.getAge() >= minAge) &&
                                   (maxAge == null || student.getAge() <= maxAge))
                .collect(Collectors.toList());
    }
    
    
    
}
