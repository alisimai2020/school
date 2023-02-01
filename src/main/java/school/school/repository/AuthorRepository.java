package school.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.school.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
