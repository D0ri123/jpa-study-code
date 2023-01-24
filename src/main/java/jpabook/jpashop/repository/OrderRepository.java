package jpabook.jpashop.repository;

import java.util.List;
import javax.persistence.EntityManager;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
  private final EntityManager em;

  public void save(Order order){
    em.persist(order);
  }

  public Order findOne(Long id){
    return em.find(Order.class, id);
  }

  public List<Order> findAll(OrderSearch orderSearch){
    return em.createQuery("select o from Order o left join o.member m", Order.class)
        .setMaxResults(1000)
        .getResultList();
  }
  
}
