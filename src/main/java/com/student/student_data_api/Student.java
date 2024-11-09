package com.student.student_data_api;

import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;

public class Student {
    private Integer id;

    @Schema(description = "Name of the student", example = "JD")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Schema(description = "Age of the student", example = "20")
    @Min(value = 1, message = "Age must be a positive integer")
    private Integer age;

    @Schema(description = "Course of the student", example = "Computer Science")
    @NotBlank(message = "Course cannot be empty")
    private String course;

    @Schema(description = "Marks of the student", example = "90.0")
    @Min(value = 0, message = "Marks must be non-negative")
    private Double marks;

    @Schema(description = "Fees paid status of the student", example = "true")
    private Boolean feesPaid = false;

    // Constructors, Getters, and Setters
    public Student() {}

    public Student(Integer id, String name, Integer age, String course, Double marks, Boolean feesPaid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
        this.feesPaid = feesPaid;
    }

    // Getters and Setters for each field
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Boolean getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(Boolean feesPaid) {
        this.feesPaid = feesPaid;
    }
}