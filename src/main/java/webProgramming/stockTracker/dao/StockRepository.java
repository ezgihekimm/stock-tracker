package webProgramming.stockTracker.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import webProgramming.stockTracker.model.Product;

@Repository
public class StockRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Product> rowMapper = new RowMapper<Product>() {

		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getLong("id"));
			product.setProductName(rs.getString("pname"));
		    product.setCount(rs.getInt("count"));
		    product.setBarcode(rs.getInt("barcode"));
		    product.setPurchasePrice(rs.getDouble("purchasePrice"));
		    product.setSalePrice(rs.getDouble("salePrice"));
		    product.setDateOfBirth(rs.getObject("dateOfBirth", LocalDate.class));
			
			return product;
		}
		
	};
	
	public List<Product> findAll(){
		String sql = "select * from product";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public Product findById(long id){
		String sql = "select * from product where id = ?";
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, id));
	}

	public void create(Product product) {
		String sql = "insert into product(pname, count, barcode, purchasePrice, salePrice, dateOfBirth) values(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, product.getProductName(),product.getCount(),product.getBarcode(),product.getPurchasePrice(),product.getSalePrice(), product.getDateOfBirth());
	}

	public void delete(long id) {
		String sql = "delete from product where id = ?";
		jdbcTemplate.update(sql, id);
	} 
}
