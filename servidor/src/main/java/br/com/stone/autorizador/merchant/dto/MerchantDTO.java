/*
* Criação : 13 de fev de 2018
*/
package br.com.stone.autorizador.merchant.dto;

import java.io.Serializable;
import br.com.stone.autorizador.infra.dto.DTO;
import br.com.stone.autorizador.merchant.entity.Merchant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objeto de transporte para {@link Merchant}
 * 
 * @author Feveriro/2018: Saulo Santos
 *         <DD>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MerchantDTO implements DTO
{

   private static final long serialVersionUID = 4436455069068517355L;
   /** Id da Entidade */
   private Long id;
   /** Nome do estabelecimento Comercial */
   private String name;

   @Override
   public Serializable getKey()
   {
      return id;
   }

}
