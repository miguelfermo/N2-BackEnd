package Projeto.Intermediario.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Projeto.Intermediario.model.User;
import Projeto.Intermediario.service.LatLonService;

@RestController
@RequestMapping("/")
public class UserController {
    private final LatLonService latlonservice;

    public UserController(LatLonService latlonservice) {
        this.latlonservice = latlonservice;
    }

    @PostMapping("/user")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user) {
        user.setUsername("Ronaldinho");  
        return user;
    }
    

    @GetMapping("/procurarlatlon")
    public ResponseEntity<Object> getWeather(@RequestParam String cidade) {
        Object response = latlonservice.getWeather(cidade);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sobre")
    @ResponseBody
    public HashMap<String, String> sobre() {
        HashMap<String, String> sobre = new HashMap<>();
        sobre.put("estudante", "Miguel Rossi Fermo");
        sobre.put("projeto", "Latitude e Longitude de Cidades!");
        return sobre;
    }

}
