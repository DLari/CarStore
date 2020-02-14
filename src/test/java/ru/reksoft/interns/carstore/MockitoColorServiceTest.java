package ru.reksoft.interns.carstore;




import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import ru.reksoft.interns.carstore.dao.ColorRepository;
import ru.reksoft.interns.carstore.dto.ColorDTO;
import ru.reksoft.interns.carstore.entity.Color;
import ru.reksoft.interns.carstore.mapper.ColorMapper;
import ru.reksoft.interns.carstore.search.SearchSpecifications;
import ru.reksoft.interns.carstore.service.ColorService;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = CarstoreApplication.class
//        //, webEnvironment= SpringBootTest.WebEnvironment.NONE
//)
public class MockitoColorServiceTest {

    @Mock
    private ColorRepository colorRepository;

    @InjectMocks
    private ColorService colorService;



    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        ColorMapper mapper = new ColorMapper();
        mapper.setModelMapper(new ModelMapper());
        colorService.setColorMapper(mapper);
    }


    @Test
    public void testGetById() {
        Color color = new Color();
        color.setId(1);
        color.setName("зеленый");
        when(colorRepository.getById(1)).thenReturn(color);

        ColorDTO color1 = colorService.getById(1);
        assertEquals(1, color1.getId().longValue());
        assertEquals("зеленый", color1.getName());

    }

    @Test
    public void testGetAll() {
        Color color = new Color();
        color.setId(1);
        color.setName("зеленый");
        color.setRemoved(false);
        List<Color> list = new ArrayList<>();
        list.add(color);
        Specification<Color> specification = SearchSpecifications.findAllNotRemovedColor();
        when(colorRepository.findAll(any(Specification.class))).thenReturn(list);

        List<ColorDTO> color1 = colorService.findColorAll();

        assertEquals(1, color1.size());
     //   assertEquals("зеленый", color1);

    }

    @Test
    public void testCreate() {
        Color color = new Color();
        color.setId(1);
        color.setName("зеленый");
        when(colorRepository.saveAndFlush(any(Color.class))).thenReturn(color);

        ColorDTO newColor = new ColorDTO();
        newColor.setName("зеленый");
        newColor.setId(1);
        ColorDTO color1 = colorService.create(newColor);
        assertEquals(1, color1.getId().longValue());
        assertEquals("зеленый", color1.getName());

    }

}
