package com.blz.springboot.greetingspringboot.controller;

import com.blz.springboot.greetingspringboot.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
/*
in postman to test the code
 http://localhost:8080/hello
 */
public class HelloWorldController {
    @RequestMapping(value = {"","/","/home"})//is a way to tell
    public String sayHello(){
        return  "hello world";
    }
    /*
    Same for here also http://localhost:8080/hello/query?name=shubham"
    where question mark is if i passed something in the query
     */
    @RequestMapping(value = {"query"},method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name")String name) {
        return  "hello" + name + "!";
    }
    /* for parameter http://localhost:8080/hello/param/Shubham
     i am passing my name to it
     */
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "hello" +  name + "!";
    }

    @GetMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello" + user.getFirstName() + " " + user.getLastName() + "!";
    }
    @GetMapping("/put/{FirstName}")
    public String sayHelloPut(@PathVariable String FirstName,@RequestParam(value="LastName") String lastName) {
        return "Hello" + FirstName + " " + "!";
    }


}
