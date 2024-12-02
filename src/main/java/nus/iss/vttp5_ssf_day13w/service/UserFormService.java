package nus.iss.vttp5_ssf_day13w.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.iss.vttp5_ssf_day13w.model.UserForm;
import nus.iss.vttp5_ssf_day13w.repo.UserFormRepo;

@Service
public class UserFormService {

    @Autowired
    UserFormRepo userFormRepo; 

    public List<UserForm> findAll() {
        return userFormRepo.findAll();
        
    }

    public UserForm findById(String personId) {
        return userFormRepo.findById(personId);
        
    }

    public Boolean create(UserForm person) {
        return userFormRepo.create(person);

    }

    public Boolean delete(UserForm person) {
        return userFormRepo.delete(person);

    }

    public Boolean update(UserForm person) {
        return userFormRepo.update(person);
    }
    
}
