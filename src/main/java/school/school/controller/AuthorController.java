package school.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import school.school.model.Author;
import school.school.model.Borrowed;
import school.school.model.Student;
import school.school.services.AuthorService;

import java.util.Optional;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/authorView")
    public String getAll(Model model){

        model.addAttribute("authorList",authorService.getAll());
        return "authorView";
    }

    @GetMapping("/ShowUpdateFormAuthor")
    public ModelAndView ShowUpdateFormAuthor(@RequestParam Long authorID){
        ModelAndView mav =new ModelAndView("authorForm");
        Author author = authorService.getAuthorById(authorID).get();
        mav.addObject("register",author);
        return mav;
    }


    @GetMapping("/authorForm")
    public ModelAndView authorForm(){
        ModelAndView mav =new ModelAndView("authorForm");
        Author author = new Author();
        mav.addObject("register",author);
        return mav;
    }

    //ADDING STUDENT INTO DATABASE
    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute Author author){
        authorService.addAuthor(author);
        return "redirect:/authorView";
    }

    //DISPLAY BY ID
    @RequestMapping("/getAuthorById")
    @ResponseBody
    public Optional<Author> getById(Long authorID){
        return authorService.getAuthorById(authorID);
    }

    @GetMapping("/deleteAuthor")
    public String delete(@RequestParam Long authorID){
        authorService.deleteMe(authorID);
        return ("redirect:/authorView");
    }
}
