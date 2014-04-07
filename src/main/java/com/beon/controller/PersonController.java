package com.beon.controller;


import com.beon.data.pojo.ErrorMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * Created by leo on 14-4-6.
 */
@Controller
public class PersonController {
//    @RequestMapping("/person/getall")
//    @ResponseBody
//    public List<Person> getAll() {
//
//
//        return PersonConverter.convert(res);
//    }


    @RequestMapping(value = "/person/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ErrorMessage add(@RequestBody Map<String, Object> person) {
//        Person person = new Person();
//        person.setAge((Integer) book.get("age"));
//        person.setName((String) book.get("name"));
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorcode(0);
        errorMessage.setErrorMessage("success");

        return errorMessage;
    }
}