/*
* Criação : 11 de fev de 2018
*/

package br.com.stone.autorizador.transaction.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.stone.autorizador.card.entity.Card;
import br.com.stone.autorizador.infra.entity.IEntity;
import br.com.stone.autorizador.merchant.entity.Merchant;
import br.com.stone.autorizador.transaction.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade Transação
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRANSACTION")
@SequenceGenerator(sequenceName="seq_transaction",name="seq_transaction", initialValue=1, allocationSize=10000)
public class Transaction implements IEntity
{

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_transaction")
   /** Numero Serial Único da Transação */
   private Long usn;
   /** Montante da transação */
   @Column(nullable = false)
   private BigDecimal amount;
   /** tipo da transacao */
   private TransactionType type;
   /** numero do cartao */
   @ManyToOne(optional= false)
   private Card card;
   /** numero de parcelas */
   private Integer number;
   /** nome do estabelecimento comercial */
   @ManyToOne
   private Merchant merchant;
   
   /** Data de Referencia da transacao */
   @Temporal(TemporalType.DATE)
   private Date referenceDate;

   @Override
   public Serializable getKey()
   {
      return usn;
   }

}
