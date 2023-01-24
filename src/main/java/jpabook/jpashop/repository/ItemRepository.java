package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        /**
         * 이미 item이 등록되어 있는 거라면, id값이 있을 것이다.
         * 등록되지 않은 item이라면, id값이 em에 저장되기 전 null이 된다.
         */
        if(item.getId() == null) em.persist(item);
        else em.merge(item);
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
