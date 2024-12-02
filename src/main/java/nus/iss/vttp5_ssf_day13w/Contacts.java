package nus.iss.vttp5_ssf_day13w;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.format.annotation.DateTimeFormat;

import nus.iss.vttp5_ssf_day13w.model.UserForm;

public class Contacts {

    private UserForm userForm;
    private String dataDir; 

    private String ID;
    private String filePath; 

    // creating file 

    // get UserForm() object 
    public Contacts(UserForm userForm, String dataDir) {
        this.userForm = userForm;
        this.dataDir = dataDir; 

        // get UserForm() ID
        this.ID = userForm.getID();

        // set file name with ID 
        // this.filePath = "peepee/joyie/" + ID;
        this.filePath = dataDir + "/" + ID;
    } 

    // write to file 
    public void writeToFile() throws IOException { 

        // ensure directory exists 
        Path dirPath = Paths.get(dataDir);
        if(!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(userForm.getID());
        bw.newLine();

        bw.write(userForm.getName());
        bw.newLine();

        bw.write(userForm.getEmail());
        bw.newLine();

        bw.write(userForm.getPhoneNumber());
        bw.newLine(); 

        bw.write(userForm.getDateOfBirth().toString());
        bw.newLine();

        bw.close(); 

    }
    


    // retrieving file 

    public Contacts(String ID, String dataDir) {
        this.ID = ID; 
        this.dataDir = dataDir; 

        // set file name with ID 
        // this.filePath = "peepee/joyie/" + ID;
        this.filePath = dataDir + "/" + ID;
        
    } 

    // read from file 

    public UserForm readFromFile() throws IOException {

        List<String> receive = new ArrayList<>();

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        String line; 

        while ((line = br.readLine()) != null) {
            receive.add(line);

        }

        br.close();  

        // format string date --> Local Date
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt = LocalDate.parse(receive.get(4), pattern);

        // create new UserForm() from file read
        UserForm userForm = new UserForm(receive.get(0), receive.get(1), receive.get(2), receive.get(3), dt);

        return userForm;

    }

    


    // retrieving all files from directory 

    public Contacts(String dataDir) {
        this.dataDir = dataDir; 
            
    } 

    public List<String> findAllFiles() {

        // loop through directory dataDir
        // add all file names to fileNames 
        File folder = new File(dataDir);
        File[] fileNames = folder.listFiles(); 

        List<String> fileStrings = new ArrayList<>(); 

        for (File file : fileNames) {
            String fileName = file.toString();
            fileStrings.add(fileName);

        }

        return fileStrings; 
            
    }
    
}
