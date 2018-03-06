/*
* Criação : 11 de fev de 2018
*/

package br.com.stone.autorizador.transaction.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import br.com.stone.autorizador.card.dto.CardDTO;
import br.com.stone.autorizador.infra.dto.DTO;
import br.com.stone.autorizador.merchant.dto.MerchantDTO;
import br.com.stone.autorizador.transaction.entity.Transaction;
import br.com.stone.autorizador.transaction.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objeto de transporte para {@link Transaction}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionDTO implements DTO
{

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = 1373407084052288715L;
   private Long usn;
   /** Montante da transação */
   private BigDecimal amount;
   /** tipo da transacao */
   private TransactionType type;
   /** numero do cartao */
   private CardDTO card;
   /** numero de parcelas */
   private Integer number;
   /** nome do estabelecimento comercial */
   private MerchantDTO merchant;
   /** Data de Referencia da transacao */
   private Date referenceDate;

   @Override
   public Serializable getKey()
   {
      return usn;
   }
}
