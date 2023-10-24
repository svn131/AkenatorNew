package ru.kata.spring.boot_security.demo.serviceSave;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.repository.Repository;

@Service
public class SaveServiceImp implements SaveService {

    private Repository repository;

    @Autowired
    public SaveServiceImp(Repository userRepository) {
        this.repository = userRepository;
    }


    @Override
    public boolean poisk(String vveli) {
        for (Znamenitost znamenitost : repository.getZnamenitostList()) {
            if (znamenitost.getName().equalsIgnoreCase(vveli)) {
                return true;
            }
        }
        return false;
    }

}

