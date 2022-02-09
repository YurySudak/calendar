package zen.calendar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zen.calendar.model.Note;

@Repository
public interface NodeRepository extends CrudRepository<Note, Long> {
}
