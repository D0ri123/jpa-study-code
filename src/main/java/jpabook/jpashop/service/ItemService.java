package jpabook.jpashop.service;

import java.util.List;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service는 Repository에 위임만 하는 역할이다.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;

  @Transactional
  public void saveItem(Item item){
    itemRepository.save(item);
  }

  public List<Item> findItems(){
    return itemRepository.findAll();
  }

  public Item findOne(Long itemId){
    return itemRepository.findOne(itemId);
  }

}
