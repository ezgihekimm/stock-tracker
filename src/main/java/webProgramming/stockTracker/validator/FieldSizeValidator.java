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

        String barcode = product.getBarcode();
        if (barcode.length() < 10 || barcode.length() > 14) {
            errors.rejectValue("barcode", "barcode.size.invalid", "Barkod alanı 10 ve 14 basamak arasında olmalı.");
        }
    }
}
