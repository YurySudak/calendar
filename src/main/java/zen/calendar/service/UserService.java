package zen.calendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zen.calendar.model.Person;
import zen.calendar.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public Iterable<Person> getUsers() {
        return userRepository.findAll();
    }
}
