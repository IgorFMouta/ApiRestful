package org.serratec.backend.apiRestfulG5.mapper;

import org.mapstruct.Mapper;
import org.serratec.backend.apiRestfulG5.domain.Pedido;
import org.serratec.backend.apiRestfulG5.model.DTO.PedidoDTO;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel="spring",uses={PedidoItemMapper.class, ClienteMapper.class})
public interface PedidoMapper {
    @Mapping(source="cliente.id", target="idCliente")
    @Mapping(source="cliente.nome", target="nomeCliente")
    PedidoDTO toDTO(Pedido pedido);

    @Mapping(source="cliente.id", target="idCliente")
    @Mapping(source="cliente.nome", target="nomeCliente")
    PedidoDTO toSimplesDTO(Pedido pedido);
    
    @Mapping(source="idCliente", target="cliente.id")
    @Mapping(target="total", ignore=true)
    Pedido toEntity(PedidoDTO pedido);
    
}
