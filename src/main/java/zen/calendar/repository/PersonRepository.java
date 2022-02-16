package zen.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zen.calendar.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByName(String name);
}
