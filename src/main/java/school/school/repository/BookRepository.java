package school.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.school.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
}
