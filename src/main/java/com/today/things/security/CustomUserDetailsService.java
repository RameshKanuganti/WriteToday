package com.today.things.security;

import com.today.things.model.TodayUser;
import com.today.things.repo.TodayUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TodayUserRepository todayUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<TodayUser> optionalTodayUser = todayUserRepository.findTop1ByEmailId(username);

        optionalTodayUser.orElseThrow(() -> new UsernameNotFoundException("User Name not found"));
        return optionalTodayUser.map(CustomUserDetails::new).get();
    }
}
