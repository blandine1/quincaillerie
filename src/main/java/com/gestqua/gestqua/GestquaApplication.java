package com.gestqua.gestqua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestquaApplication {
    //@Autowired
    //private UserRepository userRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(GestquaApplication.class, args);
    }
    

  /*    @Override
    public void run(String... args) throws Exception {

            User user = new User();
            user.setRole(Role.ADMIN);
            user.setFirstname("sonore12");
            user.setSecoundname("luc12");
            user.setPassword(new BCryptPasswordEncoder().encode("sonore12"));
            user.setEmail("sonore12@gmail.com");

            userRepository.save(user);

    }*/

}
