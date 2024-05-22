package com.twpracticespring.appws.practiceappws.userservice;

import com.twpractice.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.twpracticespring.appws.practiceappws.ui.model.request.UserDetailsRequestModel;
import com.twpracticespring.appws.practiceappws.ui.model.response.UserRest;


public interface UserService {
    UserRest getUser(String id);

    UserRest createUser(UserDetailsRequestModel userDetails);

    UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails);

    boolean deleteUser(String userId);
}

