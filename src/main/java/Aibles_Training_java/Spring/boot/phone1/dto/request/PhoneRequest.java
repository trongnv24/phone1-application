package Aibles_Training_java.Spring.boot.phone1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneRequest {
    private String name;
    private String brand;
    private String color;
    private String model;

    @Override
    public String toString() {
        return "PhoneRequest{" +
                "name='" + getName() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", color='" + getColor() + '\'' +
                ", model='" + getModel() + '\'' +
                '}';
    }
}
