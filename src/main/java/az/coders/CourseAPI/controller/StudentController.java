package az.coders.CourseAPI.controller;

import az.coders.CourseAPI.dto.StudentDTO;
import az.coders.CourseAPI.model.Student;
import az.coders.CourseAPI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
    @RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("allStudent")
    public ResponseEntity<List<StudentDTO>> getAllStudent(){
        return studentService.getStudents();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<StudentDTO>getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/groupName/{groupName}")
    public ResponseEntity<List<StudentDTO>> getStudentsByGroup(@PathVariable String groupName){
       return studentService.getStudentsByGroupName(groupName );
    }
    @PostMapping("/register")
    public ResponseEntity<String> addStudent(@RequestBody Student student,@RequestParam String groupName){
 return studentService.addStudent(student,groupName);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String>editStudent(@PathVariable Integer id,@RequestBody Student student){
        return studentService.editStudentById(id,student);
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudentById(id);
}
}
