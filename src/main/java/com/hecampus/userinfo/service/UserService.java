package com.hecampus.userinfo.service;



import com.hecampus.userinfo.dto.UserDTO;
import com.hecampus.userinfo.model.User;
import com.hecampus.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

    /**
     * Service class implementation to get list of users registered .
     * @return list of users
     */
    public List<UserDTO> getUserList() {
    return repository.findAll().stream()
        .map(
            u -> {
              UserDTO dto = new UserDTO();
              dto.setId(u.getId());
              dto.setName(u.getName());
              dto.setEmail(u.getEmail());
              return dto;
            })
        .collect(Collectors.toList());
  }

    /**
     * Service class implementation to get user according to their id.
     * @param id of user
     * @return object of user
     */
  public UserDTO getUserById(final String id) {
    return repository
        .findById(id)
        .map(
            u -> {
              UserDTO dto = new UserDTO();
              dto.setId(u.getId());
              dto.setName(u.getName());
              dto.setEmail(u.getEmail());
              return dto;
            })
        .orElse(null);
  }

    /**
     * Service class implementation to register new user.
     * @param dto object of user
     * @return full object of user
     */
  public UserDTO saveUser(final UserDTO dto) {
    User user = new User();
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    user.setPwd(dto.getPwd());
    repository.save(user);
    return dto;
  }

    /**
     * Service class implementation to update existing user.
     * @param dto user object
     */
  public void updateUser(final UserDTO dto) {
    User user = new User();
    user.setId(dto.getId());
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    user.setPwd(dto.getPwd());
    repository.save(user);
  }

    /**
     * Service class implementation to delete existing user.
     * @param dto user object
     */
  public void deleteUser(final UserDTO dto) {
    User user = new User();
    user.setId(dto.getId());
    repository.delete(user);
  }

    /**
     * Service class implementation to save user.
     * @param users user object
     */
    public User saveUser(final User users) {
        repository.save(users);
        return users;
    }
}
