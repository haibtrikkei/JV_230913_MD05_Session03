package ra.demo_webapi.dao;

import ra.demo_webapi.entity.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> getProducts();
    public Product getProductById(Integer proId);
    public boolean insertProduct(Product pro);
    public boolean updateProduct(Product pro);
    public boolean deleteProduct(Integer proId);
    public List<Product> getProductsByName(String proName);
}
