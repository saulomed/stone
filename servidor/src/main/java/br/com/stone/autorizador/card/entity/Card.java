/*
* Criação : 28 de jan de 2018
*/

package br.com.stone.autorizador.card.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import br.com.stone.autorizador.card.enums.CardBrand;
import br.com.stone.autorizador.card.enums.CardType;
import br.com.stone.autorizador.infra.entity.IEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade Cartão
 * 
 * @author Janeiro/2018: Saulo Santos
 *         <DD>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARD")
public class Card implements IEntity
{

   private static final long serialVersionUID = 266913407217227386L;
   /** numero do cartão */
   @Id
   @Column(length = 19, nullable = false, unique = true)
   @Size(min=12,max=19)
   private String number;
   /** Nome do Cliente */
   private String holderName;
   /** Data de expiração do Cartão */
   private Date expirationDate;
   /** Bandeira */
   @Enumerated(EnumType.ORDINAL)
   private CardBrand cardBrand;
   /** Senha */
   private String password;
   /** Tipo dp cartão*/
   @Enumerated(EnumType.ORDINAL)
   private CardType type;
   /** Indicador se existe senha */
   private Boolean hasPassword;

   @Override
   public Serializable getKey()
   {
      return getNumber();
   }

   /**
   * Metodo para validacao de senha do cartao
   * @param pass
   * @return
   */
   public boolean validatePass(String pass)
   {
      boolean result = false;
      if(getHasPassword() && getPassword().equals(pass))
      {
         result = true;
      }
      return result;
   }

}
