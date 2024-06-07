package Aibles_Training_java.Spring.boot.phone1.dto.response;

import Aibles_Training_java.Spring.boot.phone1.dto.request.PhoneRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneResponse extends PhoneRequest {
    private String id;

    @Override
    public String toString() {
        return "PhoneResponse{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", color='" + getColor() + '\'' +
                ", model='" + getModel() + '\'' +
                '}';
    }
}
