package com.vladimirpandurov.pagination5B.controller;

import com.vladimirpandurov.pagination5B.model.HttpResponse;
import com.vladimirpandurov.pagination5B.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;
    @GetMapping
    public ResponseEntity<HttpResponse> getUsers(@RequestParam Optional<String> name,
                                                 @RequestParam Optional<Integer> page,
                                                 @RequestParam Optional<Integer> size) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                .timeStamp(LocalTime.now().toString())
                .data(Map.of("page", userService.getUsers(name.orElse(""),page.orElse(0),size.orElse(10))))
                .message("Users Retrieved")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }

}
