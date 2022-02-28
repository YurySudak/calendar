package zen.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zen.calendar.model.Note;
import zen.calendar.model.Status;

import java.util.Collection;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query(value = "select * from note where " +
            "person_id = :id " +
            "and extract(day from date_time) = :day " +
            "and extract(month from date_time) = :month " +
            "and extract(year from date_time) = :year " +
            "and status = :status",
            nativeQuery = true)
    Collection<Note> getThem(
            @Param("id") Long id,
            @Param("day") Integer day,
            @Param("month") Integer month,
            @Param("year") Integer year,
            @Param("status") String status);
}
