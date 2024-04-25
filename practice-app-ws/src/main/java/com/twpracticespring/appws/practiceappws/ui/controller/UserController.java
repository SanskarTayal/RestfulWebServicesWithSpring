package com.twpracticespring.appws.practiceappws.ui.controller;
import com.twpracticespring.appws.practiceappws.ui.model.request.UserDetailsRequestModel;
import com.twpracticespring.appws.practiceappws.ui.model.respomse.UserRest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")


public class UserController {
    Map<String, UserRest> users;
    @GetMapping(path = "/{userid}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable String userid)
     {
         if(users.containsKey(userid))
             return new ResponseEntity<>(users.get(userid), HttpStatus.OK) ;
         else
             return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }
    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false)int page ,
                           @RequestParam(value= "limit") int limit,
                           @RequestParam(value= "sort", required = false, defaultValue = "desc") String sort)
    {
        return "Get Users was called with page no "+page+" and limit "+ limit+ " and sortvalue is " +sort;
    }
    @PostMapping(consumes =
            {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces =
                    {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        if(users==null)
            users=new HashMap<>();
        UserRest user = new UserRest();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        String userid= UUID.randomUUID().toString();
        user.setUserID(userid);
        users.put(userid,user);
        return new ResponseEntity<>(user, HttpStatus.OK);
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

