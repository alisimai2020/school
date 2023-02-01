package school.school.controller;

import org.springframework.web.servlet.ModelAndView;
import school.school.model.Student;
import school.school.services.AuthorService;
import school.school.services.BookService;
import school.school.services.BorrowedService;
import school.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService studentServices;


//ADDING STUDENT INTO DATABASE
    @PostMapping ("/saveStudent")
    public String saveStudent(@ModelAttribute  Student students){
        studentServices.addStudent(students);
        return "redirect:/";
    }

    @GetMapping("/registerForm")
    public ModelAndView registerForm(){
        ModelAndView mav =new ModelAndView("registerform");
        Student student = new Student();
        mav.addObject("register",student);
        return mav;
    }
//    DISPLAY STUDENT INTO TABLE
    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("studentList",studentServices.getAll());

        return "index";
    }


    @GetMapping("/ShowUpdateForm")
    public ModelAndView ShowUpdateForm(@RequestParam Integer stuId){
        ModelAndView mav =new ModelAndView("registerform");
        Student student = studentServices.getStudentById(stuId).get();
        mav.addObject("register",student);
        return mav;
    }




//    DISPLAY BY ID
    @RequestMapping("/getStudentById")
    @ResponseBody
    public Optional<Student> getById(Integer stuId){

        return studentServices.getStudentById(stuId);
    }

@GetMapping("/deleteStudent")
    public String delete(@RequestParam Integer stuId){
        studentServices.deleteMe(stuId);
        return ("redirect:/");
}

    }
