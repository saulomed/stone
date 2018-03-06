/*
* Criação : 13 de fev de 2018
*/
package br.com.stone.autorizador.merchant.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import br.com.stone.autorizador.infra.entity.IEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade Comerciante
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MERCHANT")
@SequenceGenerator(sequenceName="seq_merchant", name="seq_merchant", initialValue=1, allocationSize=10000)
public class Merchant implements IEntity
{

   /** Id da Entidade */
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_merchant")
   private Long id;
   /** Nome do estabelecimento Comercial */
   private String name;

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = 3622783645106511352L;

   @Override
   public Serializable getKey()
   {
      return id;
   }

}
