package org.serratec.backend.apiRestfulG5.model.pk;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.serratec.backend.apiRestfulG5.domain.Pedido;

//import br.org.serratec.backend.ecommerce.model.Produto;
//import lombok.Getter;
//import lombok.Setter;

@Embeddable
//@Getter
//@Setter
public class PedidoItemPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumn (name = "id_pedido")
	private Pedido pedido;
	
/*	@ManyToOne
	@JoinColumn (name = "id_produto")
	private Produto produto;   */

}
