package school.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import school.school.model.Author;
import school.school.model.Book;
import school.school.model.Borrowed;
import school.school.model.Student;
import school.school.services.BorrowedService;

import java.util.Optional;

@Controller
public class BorrowedController {

    @Autowired
    private BorrowedService borrowedService;



    @GetMapping("/borrowView")
    public String getAll(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("borrowList",borrowedService.getAll());
        return "borrowView";
    }

    //ADDING STUDENT INTO DATABASE
    @PostMapping("/saveBorrow")
    public String saveBorrow(Borrowed borrowed){
        borrowedService.insertBorrow(borrowed);
        return "saveBorrow";
    }

    //DISPLAY BY ID
    @RequestMapping("/getBorowById")
    @ResponseBody
    public Optional<Borrowed> getById(Long borrowID){
        return borrowedService.getBorrowtById(borrowID);
    }


    @GetMapping("/deleteBorrow")
    public String delete(Long borrowID){
        borrowedService.deleteMe(borrowID);
        return ("redirect:/");
    }
}
