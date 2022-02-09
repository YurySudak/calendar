package zen.calendar.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zen.calendar.model.Person;
import zen.calendar.service.UserService;

@RestController
@AllArgsConstructor
public class NotesController {

    private UserService userService;

    @GetMapping("")
    public Iterable<Person> getUsers() {
        return userService.getUsers();
    }

}
