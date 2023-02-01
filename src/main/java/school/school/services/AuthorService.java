package school.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.school.model.Author;
import school.school.model.Book;
import school.school.model.Student;
import school.school.repository.AuthorRepository;
import school.school.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public List<Author> getAll(){

        return authorRepository.findAll();
    }

    public Author addAuthor( Author author){
        return authorRepository.save(author);
    }



    public Optional<Author> getAuthorById(Long authorID){
        return authorRepository.findById(authorID);
    }

    public void deleteMe( Long authorID){
        authorRepository.deleteById(authorID);
    }


}
