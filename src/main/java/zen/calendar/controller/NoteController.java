package zen.calendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zen.calendar.model.Note;
import zen.calendar.model.Person;
import zen.calendar.model.Status;
import zen.calendar.repository.NoteRepository;
import zen.calendar.repository.PersonRepository;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class NoteController {

    private NoteRepository noteRepository;
    private PersonRepository personRepository;

    @GetMapping("/{id}/{month}/{year}")
    public Collection<Note> getNotesByPersonIdMonthAndYear(
            @PathVariable("id") Long id,
            @PathVariable("month") Integer month,
            @PathVariable("year") Integer year) {
        return noteRepository.getThem(id, month, year, Status.ACTIVE.toString());
    }

    @PostMapping("/")
    public ResponseEntity<Note> postNote(@RequestBody Note note) {
        Note postNote = new Note(note.getContent(), note.getDateTime());
        Person person = personRepository.findById(note.getPerson().getId()).orElse(null);
        if (null == person) return ResponseEntity.notFound().build();
        postNote.setPerson(person);
        postNote.setStatus(Status.ACTIVE);
        return ResponseEntity.ok(noteRepository.save(postNote));
    }

    @PutMapping("/")
    public ResponseEntity<Note> putNote(@RequestBody Note note) {
        Note putNote = noteRepository.findById(note.getId()).orElse(null);
        Person person = personRepository.findById(note.getPerson().getId()).orElse(null);
        if (null == putNote || null == person) return ResponseEntity.notFound().build();
        putNote.setContent(note.getContent());
        putNote.setDateTime(note.getDateTime());
        putNote.setPerson(person);
        return ResponseEntity.ok(noteRepository.save(putNote));
    }

    @DeleteMapping("/")
    public ResponseEntity delNote(@RequestBody Note note) {
        Note delNote = noteRepository.findById(note.getId()).orElse(null);
        if (null == delNote) return ResponseEntity.notFound().build();
        delNote.setStatus(Status.DELETED);
        noteRepository.save(delNote);
        return ResponseEntity.ok().build();
    }
}

