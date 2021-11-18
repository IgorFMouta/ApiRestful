package org.serratec.backend.apiRestfulG5.model.DTO;

import java.util.Date;

import org.serratec.backend.apiRestfulG5.enums.PedidoStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PedidoSimplesDTO {

	private Integer id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Date dataPedido;
	private PedidoStatus pedidoStatus;
	private Integer idCliente;
	private String nomeCliente;
}
