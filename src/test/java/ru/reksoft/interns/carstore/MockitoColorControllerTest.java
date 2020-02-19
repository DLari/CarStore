package ru.reksoft.interns.carstore;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.reksoft.interns.carstore.dto.ColorDto;
import ru.reksoft.interns.carstore.service.ColorService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


//@RunWith(SpringJUnit4ClassRunner.class)

//@ContextConfiguration(classes = {CarstoreApplication.class
//       // , WebAppContext.class
//})

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarstoreApplication.class
        //, webEnvironment= SpringBootTest.WebEnvironment.NONE
)
@WebAppConfiguration
public class MockitoColorControllerTest {

    @Mock
    private ColorService colorService;

    @Autowired
    public WebApplicationContext context;

    public MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getColor() throws Exception {
        ColorDto first = new ColorDto();
        first.setPrice(BigDecimal.valueOf(18000));
        first.setId(1);

        when(colorService.getById(1)).thenReturn(first);
        mockMvc.perform(get("/colors/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.price").value(35000));
    }


    @Test
    public void getListColors() throws Exception {
        ColorDto first = new ColorDto();
        first.setPrice(BigDecimal.valueOf(35000));
        first.setId(1);
        ColorDto second = new ColorDto();
        second.setId(2);
        second.setPrice(BigDecimal.valueOf(35000));
        List<ColorDto> list = new ArrayList<>();
        list.add(first);
        list.add(second);

        when(colorService.findColorAll()).thenReturn(list);
        mockMvc.perform(get("/colors")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(list.get(0).getId()))
                .andExpect(jsonPath("$[0].price").value(list.get(0).getPrice()))
                .andExpect(jsonPath("$[1].id").value(list.get(1).getId()))
                .andExpect(jsonPath("$[1].price").value(list.get(1).getPrice()));
    }

}
