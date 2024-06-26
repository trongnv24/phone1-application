package Aibles_Training_java.Spring.boot.phone1.service.impl;

import Aibles_Training_java.Spring.boot.phone1.dto.request.PhoneRequest;
import Aibles_Training_java.Spring.boot.phone1.dto.response.PhoneResponse;
import Aibles_Training_java.Spring.boot.phone1.entity.Phone;
import Aibles_Training_java.Spring.boot.phone1.repository.PhoneRepository;
import Aibles_Training_java.Spring.boot.phone1.service.PhoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static Aibles_Training_java.Spring.boot.phone1.service.mapping.PhoneServiceMapping.convertPhoneToPhone;
import static Aibles_Training_java.Spring.boot.phone1.service.mapping.PhoneServiceMapping.convertPhoneToPhoneResponse;

@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository repository;

    public PhoneServiceImpl(PhoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public PhoneResponse create(PhoneRequest request) {
        log.info(" === Start api create new phone === ");
        log.info(" === Request Body : {} === ", request);
        Phone phone = convertPhoneToPhone(request);
        phone = repository.save(phone);
        PhoneResponse response = convertPhoneToPhoneResponse(phone);
        log.info(" === Finish api create new phone, Phone Id : {}  === ", phone.getId());
        return response;
    }

    @Override
    public PhoneResponse getById(String id) {
        log.info(" === Start api get phone === ");
        log.info(" === String id : {} === ", id);
        Optional<Phone> optionalPhone = repository.findById(id);
        if (!optionalPhone.isPresent()) {
            throw new RuntimeException();
        }
        Phone phone = optionalPhone.get();
        PhoneResponse response = convertPhoneToPhoneResponse(phone);
        log.info(" === Finish api getById phone, Phone id :{} === ", response.getId());
        return response;
    }

    @Override
    public PhoneResponse update(String id, PhoneRequest request) {
        log.info(" === Start api update phone === ");
        log.info(" === String id : {}, Request Body : {} === ", id);
        Optional<Phone> optionalPhone = repository.findById(id);
        if (!optionalPhone.isPresent()) {
            throw new RuntimeException();
        }
        Phone phone = optionalPhone.get();
        phone.setName(request.getName());
        phone.setBrand(request.getBrand());
        phone.setModel(request.getModel());
        phone.setColor(request.getColor());
        phone = repository.save(phone);
        PhoneResponse response = convertPhoneToPhoneResponse(phone);
        log.info( " === Finish api update phone, Phone Id : {}  === ", phone.getId());
        return response;
    }

    @Override
    public void deleteById(String id) {
        log.info(" === Start api delete phone === ");
        log.info(" === String id : {} === ", id);
        Optional<Phone> optionalPhone = repository.findById(id);
        if (!optionalPhone.isPresent()) {
            throw new RuntimeException();
        }
        log.info(" === Finish api delete phone, Phone id :{} === ", id);
        repository.deleteById(id);
    }
}
