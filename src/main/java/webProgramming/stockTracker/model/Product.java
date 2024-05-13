package webProgramming.stockTracker.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;

public class Product {

	private long id;

	@Size(min = 3, max = 50)
	private String productName;
	
	@Min(0)
	private int count;
	
	@Min(0)
	private int barcode;
	
	@Min(0)
	private double purchasePrice;
	  
	@Min(0)
    private double salePrice; 

	@Past
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int count) {
        this.barcode = count;
    }

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
