package webProgramming.stockTracker.model;

import java.time.LocalDate;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class Product {

    private long id;

    @NotNull(message = "{NotNull.product.productName}")
    @Size(min = 3, max = 50, message = "{Size.product.productName}")
    private String productName;

    @Min(value = 1, message = "{Min.product.count}")
    private int count;

    @Min(value = 0, message = "{Size.product.barcode}")
    private String barcode;

    @Min(value = 5, message = "{Min.product.purchasePrice}")
    private double purchasePrice;

    @Min(value = 5, message = "{Min.product.salePrice}")
    private double salePrice;

    @NotNull(message = "{NotNull.product.dateOfBirth}")
    @Past(message = "{Past.product.dateOfBirth}")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;

    private String category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
