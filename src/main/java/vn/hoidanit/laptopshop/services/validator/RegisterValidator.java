package vn.hoidanit.laptopshop.services.validator;

import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.services.UserService;

import java.util.regex.Pattern;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {

    private final UserService userService;

    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {
        boolean valid = true;

        // Check if password fields match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            context.buildConstraintViolationWithTemplate("Passwords nhập không chính xác")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Check if email exists
        if (this.userService.checkEmailExist(user.getEmail())) {
            context.buildConstraintViolationWithTemplate("Email đã tồn tại")
                    .addPropertyNode("email")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Check if first name is empty
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("First name không được để trống")
                    .addPropertyNode("firstName")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Check if last name is empty
        if (user.getLastName() == null || user.getLastName().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Last name không được để trống")
                    .addPropertyNode("lastName")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Regex pattern to validate names (only alphabetic characters and spaces)
        Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+$");

        // Check if first name is valid
        if (!namePattern.matcher(user.getFirstName()).matches()) {
            context.buildConstraintViolationWithTemplate("First name chỉ chứa ký tự chữ và khoảng trắng")
                    .addPropertyNode("firstName")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Check if last name is valid
        if (!namePattern.matcher(user.getLastName()).matches()) {
            context.buildConstraintViolationWithTemplate("Last name chỉ chứa ký tự chữ và khoảng trắng")
                    .addPropertyNode("lastName")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        return valid;
    }
}
