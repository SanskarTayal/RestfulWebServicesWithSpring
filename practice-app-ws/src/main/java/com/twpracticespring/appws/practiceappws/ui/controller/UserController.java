package com.twpracticespring.appws.practiceappws.ui.controller;


import com.twpracticespring.appws.practiceappws.ui.model.respomse.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping(path = "/{userid}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable String userid)
     {
         UserRest returnValue = new UserRest();
         returnValue.setFirstName("Sanskar");
         returnValue.setLastName("Tayal");
         returnValue.setEmail("sanskar@tw.com");
        return new ResponseEntity<>(returnValue, HttpStatus.OK) ;
    }
    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false)int page ,
                           @RequestParam(value= "limit") int limit,
                           @RequestParam(value= "sort", required = false, defaultValue = "desc") String sort)
    {
        return "Get Users was called with page no "+page+" and limit "+ limit+ " and sortvalue is " +sort;
    }
    @PostMapping
    public String createUser()
    {
        return "Create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "Update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "Delete user was called";
    }

}

