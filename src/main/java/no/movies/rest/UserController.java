package no.movies.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value={"login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="index", method = RequestMethod.GET)
    public ModelAndView adminHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Top 10", "http://127.0.0.1:8080/top");
        modelAndView.addObject("By name", "http://127.0.0.1:8080/byName/Appollo 13");
        modelAndView.setViewName("adminHome");
        return modelAndView;
    }

}