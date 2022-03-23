package com.hecampus.userinfo.controller;



import com.hecampus.userinfo.dto.UserDTO;
import com.hecampus.userinfo.service.UserService;
//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

  @Autowired private UserService service;

 // Logger log = LoggerFactory.getLogger(this.getClass());


  /**
   * Returns a user with the id
   * @param  id the id of the user
   * @return     the user
   */
  @GetMapping("/user/{id}")
  public ResponseEntity<UserDTO> getUser(@PathVariable final String id) {
    return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
  }

  /**
   * Returns a list of users
   * @return     list of users
   */
  @GetMapping("/user")
  public ResponseEntity<List<UserDTO>> getUserList() {
    return new ResponseEntity<>(service.getUserList(), HttpStatus.OK);
  }

  /**
   * Used to register new user
   */
  @PostMapping("/user")
  public ResponseEntity<String> saveUser(@RequestBody final UserDTO userDTO) {
    service.saveUser(userDTO);
    return new ResponseEntity<>("New user successfully saved", HttpStatus.OK);
  }

  /**
   * Used to update existing user
   * @param userDTO
   */
  @PutMapping("/user")
  public ResponseEntity<String> updateUser(@RequestBody final UserDTO userDTO) {
    service.updateUser(userDTO);
    return new ResponseEntity<>("User successfully updated", HttpStatus.OK);
  }

  /**
   * Used to delete existing user
   * @param userDTO
   */
  @DeleteMapping("/user")
  public ResponseEntity<String> deleteUser(@RequestBody final UserDTO userDTO) {
    try {
      service.deleteUser(userDTO);
      return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    } catch (Exception e) {
     // log.error("Unable to delete");
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
