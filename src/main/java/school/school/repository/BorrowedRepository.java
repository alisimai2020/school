package school.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.school.model.Borrowed;

@Repository
public interface BorrowedRepository  extends JpaRepository<Borrowed,Long> {
}
