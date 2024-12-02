package nus.iss.vttp5_ssf_day13w.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import nus.iss.vttp5_ssf_day13w.Contacts;
import nus.iss.vttp5_ssf_day13w.model.UserForm;

@Controller
public class UserFormController {

    // setting default value for "--dataDir"
    @Value("${dataDir:peepee/joyie}")
    // @Value("${dataDir}")
    private String dataDir;

    // handler method for GET "/user-form" request
    @GetMapping("/user-form")
    public String getUserForm(Model model) {

        UserForm userForm = new UserForm(); 

        model.addAttribute("userForm", userForm);

        return "user-form";

    }

    // handler method for POST "/user-form" request
    @PostMapping("/contact")
    public String postUserForm(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, Model model) throws IOException {

        if (!bindingResult.hasErrors() && !userForm.validAge()) {
            bindingResult.rejectValue("dateOfBirth", "error.userForm", "Age must be betweeen 10 and 100 years");

        }

        if (bindingResult.hasErrors()) {
            // return "user-form";
        }

        model.addAttribute("userForm", userForm);

        // send userForm to "Contacts.java"
        Contacts c = new Contacts(userForm, dataDir);
        c.writeToFile();

        return "contact";

    }

    // handler method for GET "/contact/<id>" request
    @GetMapping("/contact/{ID}")
    public String IDRequest(@PathVariable("ID") String ID, Model model) throws IOException {

        // find file with ID in directory 
        // read file in directory
        // new UserForm() with data from directory

        Contacts c = new Contacts(ID, dataDir);
        UserForm userForm = c.readFromFile();

        // model.addAttribute()
        model.addAttribute("ID", ID);
        model.addAttribute("userForm", userForm);

        return "ID-request";

    }

    // handler method for GET "/contacts" request
    @GetMapping("/contacts")
    public String getContactsPage(Model model) {

        Contacts c = new Contacts(dataDir); 
        List<String> fileNames = c.findAllFiles();

        model.addAttribute("fileNames", fileNames);

        return "contacts";
    }

}
