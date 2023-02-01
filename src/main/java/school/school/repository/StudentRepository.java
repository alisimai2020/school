package school.school.repository;

import org.springframework.data.jpa.repository.Query;
import school.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

//String myquery = "SELECT student,borrowed,book,author " +
//        "WHHERE student.std_id =  borrowed.std_id and book.sbn = borrowed.sbn" +
//        "and author.authorid = book.authorid";
//
//    @Query(myquery)
//    public String getAllData();
}
