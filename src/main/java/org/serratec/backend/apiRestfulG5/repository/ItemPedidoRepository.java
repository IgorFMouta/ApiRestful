package org.serratec.backend.apiRestfulG5.repository;

import org.serratec.backend.apiRestfulG5.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{

}
