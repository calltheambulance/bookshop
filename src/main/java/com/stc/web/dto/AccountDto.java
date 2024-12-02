package com.stc.web.dto;



import com.stc.web.models.Role;
import com.stc.web.models.State;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AccountDto {

    @Email(message = "Email введён некорректно")
    private String email;

    private String password;

    @NotBlank(message = "Имя не может быть пустым")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё\\s]+$", message = "Имя должно содержать только буквы")
    private String name;

    @NotBlank(message = "Фамилия не может быть пустой")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё\\s]+$", message = "Фамилия должна содержать только")
    private String surname;


    @Pattern(
            regexp = "^((\\+7|8)[\\s-]?)?(\\(?\\d{3}\\)?[\\s-]?)?[\\d\\s-]{7,10}$",
            message = "Номер телефона должен быть в формате +7XXXXXXXXXX или 8XXXXXXXXXX"
    )
    private String phone;

    private Role role;

    private State state;

}
