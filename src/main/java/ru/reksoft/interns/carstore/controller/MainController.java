package ru.reksoft.interns.carstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.reksoft.interns.carstore.dao.ColorRepository;
import ru.reksoft.interns.carstore.dto.ColorDTO;
import ru.reksoft.interns.carstore.mapper.ColorMapper;
import ru.reksoft.interns.carstore.service.ColorService;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
//    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
//            "classpath:/META-INF/resources/", "classpath:/resources/",
//            "classpath:/static/", "classpath:/public/" };
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private ColorMapper colorMapper;
    @Autowired
    private ColorService colorService;

    private static List<ColorDTO> colors = new ArrayList<>();
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    static {

//        double p1=40000.;
//        BigDecimal pr1=BigDecimal.valueOf(p1);
//        double p2=35000.;
//        BigDecimal pr2=BigDecimal.valueOf(p2);
//        colors.add(new ColorDTO("Test1", pr1));
//        colors.add(new ColorDTO("Text2", pr2));
    }

    @RequestMapping(value = {  "/colorsHtml" }, method = RequestMethod.GET)
    public String colorsHtml(Model model) {
        model.addAttribute("message", message);
        return "colorsHtml";
    }

    @RequestMapping(value = {"/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = {"/login" }, method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("message", message);
        return "login";
    }

    @RequestMapping(value = {"/registration" }, method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("message", message);
        return "registration";
    }

    @RequestMapping(value = {"/adminIndex" }, method = RequestMethod.GET)
    public String adminIndex(Model model) {
        model.addAttribute("message", message);
        return "adminIndex";
    }

    @RequestMapping(value = {"/enginesHtml" }, method = RequestMethod.GET)
    public String enginesHtml(Model model) {
        model.addAttribute("message", message);
        return "enginesHtml";
    }

    @RequestMapping(value = {"/modelsHtml" }, method = RequestMethod.GET)
    public String modelsHtml(Model model) {
        model.addAttribute("message", message);
        return "modelsHtml";
    }

    @RequestMapping(value = {"/carcassHtml" }, method = RequestMethod.GET)
    public String carcassHtml(Model model) {
        model.addAttribute("message", message);
        return "carcassHtml";
    }

    @RequestMapping(value = {"/createColor" }, method = RequestMethod.GET)
    public String createColor(Model model) {
        model.addAttribute("message", message);
        return "createColor";
    }

    @RequestMapping(value = {"/createEngine" }, method = RequestMethod.GET)
    public String createEngine(Model model) {
        model.addAttribute("message", message);
        return "createEngine";
    }

    @RequestMapping(value = {"/carsHtml" }, method = RequestMethod.GET)
    public String carsHtml(Model model) {
        model.addAttribute("message", message);
        return "carsHtml";
    }

    @RequestMapping(value = {"/createModel" }, method = RequestMethod.GET)
    public String createModel(Model model) {
        model.addAttribute("message", message);
        return "createModel";
    }

//    @RequestMapping(value = {"/image" }, method = RequestMethod.GET)
//    public String image(Model model) {
//        model.addAttribute("message", message);
//        return "image";
//    }

}
