package com.today.things.serviceImpl;

import com.today.things.dto.UserDTO;
import com.today.things.model.TodayUser;
import com.today.things.repo.UserRepository;
import com.today.things.serviceI.UserServiceI;
import com.today.things.util.TodayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceI {

    @Autowired
    UserRepository userRepository;

    @Override
    public TodayResponse register(UserDTO userDTO) {

        if (userDTO != null) {
            TodayUser todayUser = new TodayUser();
            if (userDTO.getFullName() != null) {
                todayUser.setFullName(userDTO.getFullName());
                if (userDTO.getEmailId() != null) {
                    todayUser.setEmailId(userDTO.getEmailId());
                    if (userDTO.getPhoneNumber() != null) {
                        todayUser.setPhoneNumber(userDTO.getPhoneNumber());
                        if (userDTO.getPassword() != null) {
                            todayUser.setPassword(userDTO.getPassword());
                            userRepository.save(todayUser);
                        }
                    }
                }
            }
        }
        return null;
    }
}
