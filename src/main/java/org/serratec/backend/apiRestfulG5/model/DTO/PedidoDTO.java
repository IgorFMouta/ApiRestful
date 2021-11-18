package org.serratec.backend.apiRestfulG5.model.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.serratec.backend.apiRestfulG5.enums.PedidoStatus;
import lombok.Data;

@Data
public class PedidoDTO {

	private Integer id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Date dataPedido;

	private PedidoStatus pedidoStatus;

	private Integer idCliente;
	private String nomeCliente;

	@Valid      //Verificar classe DTO e se nescessário cria-la
	private Set<Item_PedidoDTO> itens = new HashSet<>();

    private Double total;

	public Map<String, ?> getId() {
		// TODO Auto-generated method stub
		return null;
	}


}
