package Aibles_Training_java.Spring.boot.phone1.service.impl;

import Aibles_Training_java.Spring.boot.phone1.dto.request.PhoneRequest;
import Aibles_Training_java.Spring.boot.phone1.dto.response.PhoneResponse;
import Aibles_Training_java.Spring.boot.phone1.entity.Phone;
import Aibles_Training_java.Spring.boot.phone1.repository.PhoneRepository;
import Aibles_Training_java.Spring.boot.phone1.service.PhoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
