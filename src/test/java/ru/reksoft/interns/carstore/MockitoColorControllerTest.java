package ru.reksoft.interns.carstore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.reksoft.interns.carstore.controller.ColorController;
import ru.reksoft.interns.carstore.dao.ColorRepository;
import ru.reksoft.interns.carstore.dto.ColorDTO;
import ru.reksoft.interns.carstore.mapper.ColorMapper;
import ru.reksoft.interns.carstore.service.ColorService;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class MockitoColorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private ColorService colorService;

    @Mock
    private ColorRepository colorRepository;

    @InjectMocks
    private ColorController colorController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        ColorMapper mapper = new ColorMapper();
        mapper.setModelMapper(new ModelMapper());
        colorService.setColorMapper(mapper);
        colorController.setColorService(colorService);
    }


//    @Test
//    public void getColorByIdAPI() throws Exception {
//       final ResultActions resultActions = mvc.perform( MockMvcRequestBuilders
//                .get("/colors/{id}", 1)
//                .accept(MediaType.APPLICATION_JSON_VALUE));
//       resultActions.andExpect(jsonPath.)
//
//    }
//
//    @Test
//    public void testCreareByAPI() throws Exception {
//        ColorDTO colorDTO = new ColorDTO();
//        colorDTO.setId(1);
//        colorDTO.setName("зеленый");
//        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/сolors/1")
//                .content(ClassToStringUtils.parse(colorDTO)).contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andReturn();
//    }

}
