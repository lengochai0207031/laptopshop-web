package vn.hoidanit.laptopshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.controllers.repository.RoleRepository;
import vn.hoidanit.laptopshop.controllers.repository.UserRepository;
import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  public UserService(UserRepository userRepository, RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;

  }

  public User handleSaveUser(User user) {
    User eric = this.userRepository.save(user);
    return eric;

  }

  public List<User> getUserPage() {
    return this.userRepository.findAll();
  }

  // public List<User> getAllUsersByEmail(String email) {
  // return this.userRepository.findByEmail(email);
  // }

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

  public boolean checkEmailExist(String email) {
    return this.userRepository.existsByEmail(email);
  }

  public User getUserByEmail(String email) {
    return this.userRepository.findByEmail(email);
  }

  public Object countUsers() {
    return this.userRepository.count();
  }

  public Object countOrders() {
    return this.userRepository.count();
  }

  public Object countProducts() {
    return this.userRepository.count();
  }
}
