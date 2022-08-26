package image.imageShow.serviceTest;

import image.imageShow.model.Image;
import image.imageShow.service.ImageService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ImageShowServiceTest {

    @Autowired
    private ImageService imageService;

    @BeforeEach
    public void setUp(){

    }

    @AfterEach
    public void tearDown(){

    }

    @Test
    public void saveImage(){
   Image image = new Image();
   image.setId(1L);
   image.setName("Ajibade");
   image.setPrice(250.00);
   image.setDescription("Ajibade fine art");

    imageService.saveImage(image);

   assertThat(image.getId()).isNotEqualTo(null);
   assertThat(image.getName()).isEqualTo("Ajibade");
   assertThat(image.getPrice()).isEqualTo(250.00);
   assertThat(image.getDescription()).isEqualTo("Ajibade fine art");
    }

    @Test
   public void getAllActiveImages(){

        Image image = new Image();
        image.setId(1L);
        image.setName("Ajibade");
        image.setPrice(250.00);
        image.setDescription("Ajibade fine art");

        Image image2 = new Image();
        image2.setId(2L);
        image2.setName("Ajigbowo");
        image2.setPrice(400.00);
        image2.setDescription("Ajigbowo fine art");

        imageService.saveImage(image);
        imageService.saveImage(image2);

        //when
        List<Image> images = imageService.getAllActiveImages();

        //assert
        assertThat(images.size()).isEqualTo(2);
        assertThat(images.get(0).getId()).isEqualTo(image.getId());
        assertThat(images.get(0).getName()).isEqualTo(image.getName());
        assertThat(images.get(0).getPrice()).isEqualTo(image.getPrice());
        assertThat(images.get(0).getDescription()).isEqualTo(image.getDescription());
        assertThat(images.get(1).getId()).isEqualTo(image2.getId());
        assertThat(images.get(1).getName()).isEqualTo(image2.getName());
        assertThat(images.get(1).getPrice()).isEqualTo(image2.getPrice());
        assertThat(images.get(1).getDescription()).isEqualTo(image2.getDescription());
   }

   @Test
   public void getImageById(){

       Image image = new Image();
       image.setId(1L);
       image.setName("Ajibade");
       image.setPrice(250.00);
       image.setDescription("Ajibade fine art");

       imageService.saveImage(image);

       Optional<Image> images = imageService.getImageById(1L);

       //assert
       assertThat(images.get()).isNotNull();

   }
}
