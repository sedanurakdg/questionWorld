    package com.example.questionworld.controller;


    import com.example.questionworld.dto.OpUserP;
    import com.example.questionworld.model.OpUser;
    import com.example.questionworld.service.IOperationalService;
    import lombok.AllArgsConstructor;
    import lombok.extern.log4j.Log4j2;
    import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
    import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @EnableAutoConfiguration
    @CrossOrigin("*")
    @Log4j2
    @AllArgsConstructor
    public class LoginController {
        private final IOperationalService operationalService;

        @PostMapping
        public ResponseEntity<OpUser> createOpUser(@RequestBody OpUserP opUserP) {
            return ResponseEntity.ok(operationalService.createOpUser(opUserP));
        }
        @GetMapping("/{id}")
        public ResponseEntity<OpUser> getUserById(@PathVariable("id") Integer id) {
            return ResponseEntity.ok(operationalService.getUserById(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<OpUser> editOpUser(@PathVariable("id") Integer id,@RequestBody OpUserP opUserP) {
            return ResponseEntity.ok(operationalService.editOpUser(id,opUserP));
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
            operationalService.deleteUser(id);
            return ResponseEntity.ok("User Deleted. ID:" + id);
        }

        @PutMapping("/changepassword/{id}")
        public ResponseEntity<String> changePassword(@PathVariable("id") Integer opUserId,
                                                     @RequestBody String password) {
            operationalService.changePassword(opUserId, password);
            return ResponseEntity.ok("Success");
        }
        @GetMapping("/login")
        public ResponseEntity<String> changePassword(@RequestBody OpUserP opUserP) {
            operationalService.login(opUserP);
            return ResponseEntity.ok("Success");
        }


    }
