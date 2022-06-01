package zoo.project;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zoo.project.controller.DivisionsController;


@SpringBootApplication
public class ZooApplication {

	public static void main(String[] args) {
		new File(DivisionsController.uploadDirectory).mkdir();
		SpringApplication.run(ZooApplication.class, args);
	}

}
