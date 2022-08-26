package image.imageShow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"image.imageShow"})
public class ImageShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageShowApplication.class, args);
	}

}
