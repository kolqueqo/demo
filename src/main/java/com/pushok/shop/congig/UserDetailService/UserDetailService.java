package com.pushok.shop.congig.UserDetailService;


import com.pushok.shop.entity.UserEntity;
import com.pushok.shop.repo.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    public UserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        try {
            UserEntity user = userRepo.findUserEntityByUsername(username);
            if (user != null) {
                System.out.println(user);
                UserDetails userman = User.withUsername(user.getUsername()).password(user.getPassword())
                        .roles(user.getRole())
                        .build();
                return userman;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(username);


        throw new UsernameNotFoundException(username);
    }


}
