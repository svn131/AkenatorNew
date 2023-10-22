//package ru.kata.spring.boot_security.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ru.kata.spring.boot_security.demo.model.Znamenitost;
//import ru.kata.spring.boot_security.demo.model.Vopros;
//import ru.kata.spring.boot_security.demo.repository.ZnamenitostRepository;
//import ru.kata.spring.boot_security.demo.service.UserService;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/adminProfile")
//public class AdminController {
//
//    private final UserService userService;
//    private final ZnamenitostRepository roleRepository;
//
//    @Autowired
//    public AdminController(UserService userService, ZnamenitostRepository roleRepository) {
//        this.userService = userService;
//        this.roleRepository = roleRepository;
//    }
//
//
//    @GetMapping()
//    public ResponseEntity<List<Vopros>> getAllUsers() {
//        System.out.println("555555555555555555555555555555555555555555555555555555555555555555");
//        return new ResponseEntity<>(userService.getListOfUsers(), HttpStatus.OK);
//    }
//
//    @GetMapping("/roles")
//    public ResponseEntity<List<Znamenitost>> getAllRoles() {
//        return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
//    }
//
//
//    @PostMapping("/newUser")
//    public ResponseEntity<Vopros> createUser(@RequestBody Vopros user) {
////        userService.saveUser(user);
//        System.out.println(           "Aaaaaaaaaaaaaa user"                      );
//        return ResponseEntity.ok(user);
//    }
//
//
//    @GetMapping("/{id}/edit")
//    public ResponseEntity<Map<String, Object>> editUser(@PathVariable("id") Long id) {
//        Map<String, Object> response = new HashMap<>();
//
//        response.put("roles", roleRepository.findAll());
//        response.put("user", userService.getUserById(id));
//
//        return ResponseEntity.ok(response);
//    }
//
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<Vopros> update(@RequestBody Vopros user/*, @PathVariable("id") Long id*/) {
//        userService.saveUser(user);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Vopros> getUser(@PathVariable("id") Long id) {
//        Vopros user = userService.getUserById(id);
//        return user != null
//                ? new ResponseEntity<>(user, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
//        try {
//            userService.deleteUser(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//}
//
//
