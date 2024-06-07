package Aibles_Training_java.Spring.boot.phone1.service;

import Aibles_Training_java.Spring.boot.phone1.dto.request.PhoneRequest;
import Aibles_Training_java.Spring.boot.phone1.dto.response.PhoneResponse;

public interface PhoneService {
    PhoneResponse create(PhoneRequest request);
    PhoneResponse getById(String id);
}
