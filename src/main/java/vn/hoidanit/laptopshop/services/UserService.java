package vn.hoidanit.laptopshop.services;

import java.util.List;
import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.domain.User;;

@Service
public class UserService {
  private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


    public String handleHellos(){
      return"Hello  from  Server";
    }

    public User handleSaveUser(User user){
      User eric =this.userRepository.save(user);
     return eric;

    }


    public List< User>getUserPage(){
     return this.userRepository.findAll();


    }

    public List<User>getAllUsersByEmail(String email){
    return this.userRepository.findByEmail(email);

    }
}
