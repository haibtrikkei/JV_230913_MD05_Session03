package ra.demo_webapi.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.demo_webapi.dao.ProductDAO;
import ra.demo_webapi.entity.Product;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProducts() {
        Session session = sessionFactory.openSession();
        try {
            List list = session.createQuery("from Product").list();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Product getProductById(Integer proId) {
        Session session = sessionFactory.openSession();
        try{
            Product product = session.get(Product.class, proId);
            return product;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertProduct(Product pro) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(pro);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product pro) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(pro);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Integer proId) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(getProductById(proId));
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Product> getProductsByName(String proName) {
        if(proName==null || proName.length()==0)
            proName = "%";
        else
            proName = "%"+proName+"%";
        Session session = sessionFactory.openSession();
        try {
            List list = session.createQuery("from Product where proName like :proName")
                    .setParameter("proName",proName)
                    .list();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
