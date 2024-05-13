package ra.demo_webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.demo_webapi.dao.ProductDAO;
import ra.demo_webapi.entity.Product;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/product-service")
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    @GetMapping("")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<Product> getListProducts(){
        return productDAO.getProducts();
    }

    @PostMapping("")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseBody
    public String insertProduct(@RequestBody Product pro){
        boolean bl = productDAO.insertProduct(pro);
        return String.valueOf(bl);
    }

    @PutMapping("")
    public String updateProduct(@RequestBody Product pro){
        boolean bl = productDAO.updateProduct(pro);
        return String.valueOf(bl);
    }

    @DeleteMapping("/{proId}")
    @ResponseBody
    public String deleteProduct(@PathVariable("proId")Integer proId){
        boolean bl = productDAO.deleteProduct(proId);
        return String.valueOf(bl);
    }

    @GetMapping("/searchProductName/{proName}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<Product> getProductsByName(@PathVariable("proName")String proName){
        return productDAO.getProductsByName(proName);
    }

    @GetMapping("/getProduct/{proId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseBody
    public Product getProductById(@PathVariable("proId")Integer proId){
        return productDAO.getProductById(proId);
    }
}
