package school.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.school.model.Borrowed;
import school.school.model.Student;
import school.school.repository.BorrowedRepository;

import java.util.List;
import java.util.Optional;


@Service
public class BorrowedService {
    @Autowired
    private BorrowedRepository borrowedRepository;

    public List<Borrowed> getAll(){
        return borrowedRepository.findAll();
    }

    public Borrowed insertBorrow( Borrowed borrowed){
        return borrowedRepository.save(borrowed);
    }

    public Borrowed updateBorrow(Borrowed borrowed){
        return borrowedRepository.save(borrowed);
    }

    public Optional<Borrowed> getBorrowtById(Long borrowID){
        return borrowedRepository.findById(borrowID);
    }

    public void deleteMe( Long borrowID){
        borrowedRepository.deleteById(borrowID);
    }

}
