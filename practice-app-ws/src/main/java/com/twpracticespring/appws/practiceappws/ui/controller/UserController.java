package com.twpracticespring.appws.practiceappws.ui.controller;

import com.twpracticespring.appws.practiceappws.ui.model.request.UserDetailsRequestModel;
import com.twpracticespring.appws.practiceappws.ui.model.respomse.UserRest;
import com.twpracticespring.appws.practiceappws.userservice.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.twpractice.app.ws.ui.model.request.UpdateUserDetailsRequestModel;

@RestController
@RequestMapping("users")


public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{userid}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable String userid) {
        UserRest fetchedUserDetails = userService.getUser(userid);
        if (fetchedUserDetails != null)
            return new ResponseEntity<>(fetchedUserDetails, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                           @RequestParam(value = "limit") int limit,
                           @RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {
        return "Get Users was called with page no " + page + " and limit " + limit + " and sortvalue is " + sort;
    }

    @PostMapping(consumes =
            {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces =
                    {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userid}",
            consumes =
                    {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces
                    = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<UserRest> updateUser(@PathVariable String userid,
                                               @RequestBody UpdateUserDetailsRequestModel userDetails) {
        UserRest updatedUserDetails = userService.updateUser(userid, userDetails);
        if (updatedUserDetails == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedUserDetails, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable String userid) {
        userService.deleteUser(userid);
        return ResponseEntity.noContent().build();
    }
}

