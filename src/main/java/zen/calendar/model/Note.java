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
    int position;

    public Note(String content, LocalDateTime dateTime, int position) {
        this.content = content;
        this.dateTime = dateTime;
        this.position = position;
    }
}
