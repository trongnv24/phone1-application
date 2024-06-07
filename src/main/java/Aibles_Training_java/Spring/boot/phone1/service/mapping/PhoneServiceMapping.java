package Aibles_Training_java.Spring.boot.phone1.service.mapping;

import Aibles_Training_java.Spring.boot.phone1.dto.request.PhoneRequest;
import Aibles_Training_java.Spring.boot.phone1.dto.response.PhoneResponse;
import Aibles_Training_java.Spring.boot.phone1.entity.Phone;

public class PhoneServiceMapping {
    public static Phone convertPhoneToPhone(PhoneRequest dto) {
         Phone phone = new Phone();
         phone.setName(dto.getName());
         phone.setBrand(dto.getBrand());
         phone.setModel(dto.getModel());
         phone.setColor(dto.getColor());
         return phone;
    }
    public static PhoneResponse convertPhoneToPhoneResponse(Phone phone) {
        PhoneResponse response = new PhoneResponse();
        response.setId(phone.getId());
        response.setName(phone.getName());
        response.setBrand(phone.getBrand());
        response.setModel(phone.getModel());
        response.setColor(phone.getColor());
        return response;
    }
}
