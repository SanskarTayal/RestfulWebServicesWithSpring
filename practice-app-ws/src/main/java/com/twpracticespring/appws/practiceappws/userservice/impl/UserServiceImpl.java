package com.twpracticespring.appws.practiceappws.userservice.impl;
import com.twpractice.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.twpracticespring.appws.practiceappws.shared.Utils;
import com.twpracticespring.appws.practiceappws.ui.model.request.UserDetailsRequestModel;
import com.twpracticespring.appws.practiceappws.ui.model.respomse.UserRest;
import com.twpracticespring.appws.practiceappws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, UserRest> users;

    private final Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest getUser(String id) {
        if (users != null && users.containsKey(id)) {
            return users.get(id);
        }
        return null;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest newUser = new UserRest();
        String userId = utils.getID();
        newUser.setUserID(userId);
        newUser.setFirstName(userDetails.getFirstName());
        newUser.setLastName(userDetails.getLastName());
        newUser.setEmail(userDetails.getEmail());

        if (users == null) users = new HashMap<>();
        users.put(userId, newUser);
        return newUser;
    }

    @Override
    public UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails) {
        if(users==null || !users.containsKey(userId)) {
            return null;
        }

        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @Override
    public void deleteUser(String userId) {
        users.remove(userId);
    }
}