package Aibles_Training_java.Spring.boot.phone1.controller;

import Aibles_Training_java.Spring.boot.phone1.dto.request.PhoneRequest;
import Aibles_Training_java.Spring.boot.phone1.dto.response.PhoneResponse;
import Aibles_Training_java.Spring.boot.phone1.service.PhoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/phones")
@Slf4j
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneResponse create(@RequestBody PhoneRequest request){
       log.info(" === Start api create new phone === ");
       log.info(" === Request Body : {} === ", request);
       PhoneResponse response = phoneService.create(request);
       log.info(" === Finish api create new phone, Phone Id : {} === ", response.getId());
       return response;
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PhoneResponse getById(@PathVariable("id") String id){
        log.info(" === Start api get phone === ");
        log.info(" === String id : {} === ", id);
        PhoneResponse response = phoneService.getById(id);
        log.info(" Finish api get phone , Phone Id : {} === ", response.getId());
        return response;
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PhoneResponse update(@PathVariable("id") String id, @RequestBody PhoneRequest request){
        log.info(" === Start api update phone === ");
        log.info(" === String id : {}, Request Body : {} === ", id, request);
        PhoneResponse response = phoneService.update(id, request);
        log.info(" === Finish api update phone, Phone Id : {} === ", response.getId());
        return response;
    }
}
