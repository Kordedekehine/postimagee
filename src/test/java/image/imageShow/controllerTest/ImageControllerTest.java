package image.imageShow.controllerTest;

import image.imageShow.model.Image;
import image.imageShow.service.ImageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ImageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ImageService imageService;

//    @Test
//     void getAllActiveImages() throws Exception {
//         List<Image> images = new ArrayList<>();
//         images.add(new Image(1L,"hello","just greeting",760.00));
//         images.add(new Image(2L,"hi","just answering",550.00));
//         when(imageService.getAllActiveImages()).thenReturn(images);
//
//         mockMvc.perform(MockMvcRequestBuilders.get("images")
//                 .contentType(MediaType.APPLICATION_JSON)
//         ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
//     }

     }


