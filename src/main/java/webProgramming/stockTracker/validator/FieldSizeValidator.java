package webProgramming.stockTracker.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import webProgramming.stockTracker.model.Product;


@Component
public class FieldSizeValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        // Barcode değerinin 10 ile 14 karakter uzunluğunda olup olmadığını kontrol etme
        String barcode = String.valueOf(product.getBarcode());
        if (barcode.length() < 10 || barcode.length() > 14) {
            errors.rejectValue("barcode", "barcode.size.invalid");
        }
    }
}