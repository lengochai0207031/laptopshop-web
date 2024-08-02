package vn.hoidanit.laptopshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.repository.RolesRepository;
import vn.hoidanit.laptopshop.repository.UserRepository;;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final RolesRepository roleRepository;

  public UserService(UserRepository userRepository, RolesRepository roleRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;

  }

  public User handleSaveUser(User user) {
    return this.userRepository.save(user);

  }

  public List<User> getUserPage() {
    return this.userRepository.findAll();
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
