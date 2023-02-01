package school.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import school.school.model.Author;
import school.school.model.Book;
import school.school.model.Borrowed;
import school.school.model.Student;
import school.school.services.AuthorService;
import school.school.services.BookService;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/bookView")
    public String getAllBook(Model model){
        model.addAttribute("author",new Author());
        model.addAttribute("bookList",bookService.getAllBook());
        return "bookView";
    }

    @GetMapping("/bookForm")
    public ModelAndView bookForm(Model model){
        ModelAndView mav =new ModelAndView("bookForm");
        Book book= new Book();


        mav.addObject("book",book);
        return mav;
    }
    //ADDING STUDENT INTO DATABASE
    @PostMapping("/saveBook")
    public String saveStudent(Book book){
        bookService.addBook(book);
        return "saveBook";
    }

    //DISPLAY BY ID
    @RequestMapping("/getBookById")
    @ResponseBody
    public Optional<Book> getBookById(String SBN){
        return bookService.getBookById(SBN);
    }

    @GetMapping("/deleteBook")
    public String deleteBook(String SBN){
        bookService.deleteMe(SBN);
        return ("delete");
    }





}
