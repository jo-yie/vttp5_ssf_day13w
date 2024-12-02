package nus.iss.vttp5_ssf_day13w.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Repository;

import nus.iss.vttp5_ssf_day13w.model.UserForm;

@Repository
public class UserFormRepo {
    
    private List<UserForm> userFormList = new ArrayList<>(); 

    public UserFormRepo() {

        LocalDate dob = LocalDate.of(2000, 12, 24);
        UserForm person = new UserForm("Jo Yie", "joyieleong@gmail.com", "8888888", dob);
        userFormList.add(person);

    }

    public List<UserForm> findAll() {
        return userFormList;
        
    }

    public UserForm findById(String userFormID) {
        UserForm foundUser = userFormList.stream().filter(p -> p.getID().equals(userFormID)).findFirst().get();

        return foundUser;

    }

    public Boolean create(UserForm userForm) {
        userFormList.add(userForm);
        return true;

    }

    public Boolean delete(UserForm userForm) {
        int iFoundUser = userFormList.indexOf(userForm);

        if (iFoundUser >= 0) {
            userFormList.remove(userForm);
            return true;

        }

        return false; 

    }

    public Boolean update(UserForm userForm) { 
        List<UserForm> filteredUser = userFormList.stream().filter(p -> p.getID().equals(userForm.getID())).collect(Collectors.toList());
        
        if (filteredUser.size() >= 0) {
            userFormList.remove(filteredUser.getFirst()); 
            userFormList.add(userForm);
            return true;

        }

        return false;

    }

}
