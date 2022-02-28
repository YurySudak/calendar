package zen.calendar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime dateTime;
    @ManyToOne
    private Person person;
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private Status status;
    private int position;
    private boolean executed;
    private final LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated = LocalDateTime.now();


    public Note(String content, LocalDateTime dateTime, int position, boolean executed) {
        this.content = content;
        this.dateTime = dateTime;
        this.position = position;
        this.executed = executed;
    }
}
