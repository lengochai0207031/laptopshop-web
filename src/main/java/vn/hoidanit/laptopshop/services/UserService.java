package vn.hoidanit.laptopshop.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.repository.RoleRepository;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public String handleHellos() {
    return "Hello  from  Server";
  }

  public User handleSaveUser(User user) {
    User eric = this.userRepository.save(user);
    return eric;

  }

  public List<User> getUserPage() {
    return this.userRepository.findAll();

  }

  public List<User> getAllUsersByEmail(String email) {
    return this.userRepository.findByEmail(email);

  }

  public User getAllUsersById(long id) {
    return this.userRepository.findById(id);

  }

  public void deleteUser(long id) {
    this.userRepository.deleteById(id);
  }

  public Role getRoleName(String name) {
    return this.roleRepository.findByName(name);

  }

  // map Dto vs user nha bạn hải khùng

  public User mapRegistertoUser(RegisterDTO registerDTO) {

    User user = new User();
    user.setFullName(registerDTO.getFirstName() + "" + registerDTO.getLastName());
    user.setEmail(registerDTO.getEmail());
    user.setPassWord(registerDTO.getPassword());
    return user;
  }
}
