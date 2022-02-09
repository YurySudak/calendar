package zen.calendar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zen.calendar.model.Person;

@Repository
public interface UserRepository extends CrudRepository<Person, Long> {
}
