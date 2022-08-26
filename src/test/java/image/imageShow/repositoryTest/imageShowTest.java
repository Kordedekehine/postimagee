package image.imageShow.repositoryTest;

import image.imageShow.model.Image;
import image.imageShow.repository.ImageShowRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class imageShowTest {

    @Autowired
    private ImageShowRepository imageShowRepository;

    @BeforeEach
    void setUp(){

    }

    @AfterEach
    void tearDown(){

    }

    @Test
    public void findAll(){

        Image image0 = new Image();
        image0.setId(1L);
        image0.setName("Big Art");
        image0.setDescription("An art that is big");
        image0.setPrice(34500.00);

//        Image image1 = new Image();
//        image1.setId(2L);
//        image1.setName("small Art");
//        image1.setDescription("An art that is small");
//        image1.setPrice(4500.00);

        Image saveImage = imageShowRepository.save(image0);
      //  Image saveImage1 = imageShowRepository.save(image1);

        assertThat(saveImage.getName()).isEqualTo(image0.getName());
        assertThat(saveImage.getId()).isEqualTo(image0.getId());
        assertThat(saveImage.getPrice()).isEqualTo(image0.getPrice());
        assertThat(saveImage.getDescription()).isEqualTo(image0.getDescription());

//        assertThat(saveImage1.getName()).isEqualTo(image1.getName());
//        assertThat(saveImage1.getId()).isEqualTo(image1.getId());
//        assertThat(saveImage1.getPrice()).isEqualTo(image1.getPrice());
//        assertThat(saveImage1.getDescription()).isEqualTo(image1.getDescription());

        //when
       List<Image> images = imageShowRepository.findAll();

       //assert
        assertThat(images.size()).isEqualTo(1);
        assertThat(images.get(0).getId()).isEqualTo(saveImage.getId());
        assertThat(images.get(0).getName()).isEqualTo(saveImage.getName());
        assertThat(images.get(0).getDescription()).isEqualTo(saveImage.getDescription());
        assertThat(images.get(0).getPrice()).isEqualTo(saveImage.getPrice());

        //assert
//        assertThat(images.get(0).getId()).isEqualTo(saveImage1.getId());
//        assertThat(images.get(0).getName()).isEqualTo(saveImage1.getName());
//        assertThat(images.get(0).getDescription()).isEqualTo(saveImage1.getDescription());
//        assertThat(images.get(0).getPrice()).isEqualTo(saveImage1.getPrice());

    }

     @Test
    void findById(){
        Image image = new Image();
        image.setId(1L);
        image.setName("unique art");
        image.setDescription("a distinctive app");
        image.setPrice(5000.00);
        Image saveImage = imageShowRepository.save(image);

      assertThat(saveImage.getId()).isEqualTo(image.getId());
      assertThat(saveImage.getName()).isEqualTo(image.getName());
      assertThat(saveImage.getPrice()).isEqualTo(image.getPrice());
      assertThat(saveImage.getDescription()).isEqualTo(image.getDescription());

      //when
         Optional<Image> foundImage = imageShowRepository.findById(saveImage.getId());

        assertThat(foundImage.get().getId()).isEqualTo(image.getId());
        assertThat(foundImage.get().getName()).isEqualTo(image.getName());
        assertThat(foundImage.get().getDescription()).isEqualTo(image.getDescription());
        assertThat(foundImage.get().getPrice()).isEqualTo(image.getPrice());
     }
}
