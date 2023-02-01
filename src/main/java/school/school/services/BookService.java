package school.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.school.model.Author;
import school.school.model.Book;
import school.school.model.Student;
import school.school.repository.AuthorRepository;
import school.school.repository.BookRepository;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookrepository;


    public List<Book> getAllBook(){
        return bookrepository.findAll();
    }

    public Book addBook(Book book){
        return bookrepository.save(book);
    }


    public Book updateBook(Book book){

        return bookrepository.save(book);
    }

    public Optional<Book> getBookById(String SBN){
        return bookrepository.findById(SBN);
    }


    public void deleteMe( String SBN){
        bookrepository.deleteById(SBN);
    }


}
