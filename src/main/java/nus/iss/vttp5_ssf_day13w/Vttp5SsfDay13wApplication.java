package nus.iss.vttp5_ssf_day13w;

import java.io.File;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class Vttp5SsfDay13wApplication {

	public static void main(String[] args) {
		SpringApplication.run(Vttp5SsfDay13wApplication.class, args);


		// ApplicationArguments cliOpts = new DefaultApplicationArguments(args);

		// // if --dataDir not specified, exit
		// if (!cliOpts.containsOption("dataDir")) {
		// 	System.err.println("--dataDir not specified");
		// 	System.exit(1);
		// }

		// // retrieve value of --dataDir
		// String inputDirectory = cliOpts.getOptionValues("dataDir").get(0);
		// // System.out.println(inputDirectory);

		// File directory = new File(inputDirectory);

		// if (!directory.exists()) {
		// 	boolean dirCreated = directory.mkdirs(); 
		// 	if (dirCreated) {
		// 		System.out.println("Directory successfully created");
		// 	} else {
		// 		System.err.println("Failed to create directory");
		// 		System.exit(0);
		// 	}
		// } else {
		// 	System.out.println("Directory already exists");
		// }
		
	}

}
