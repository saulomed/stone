/*
* Criação : 28 de jan de 2018
*/
package br.com.stone.autorizador.card.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Enumerated;
import br.com.stone.autorizador.card.entity.Card;
import br.com.stone.autorizador.card.enums.CardBrand;
import br.com.stone.autorizador.card.enums.CardType;
import br.com.stone.autorizador.infra.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objeto de transporte para {@link Card}
 * 
 * @author Janeiro/2018: Saulo Santos
 *         <DD>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardDTO implements DTO
{

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = 2702907850222900131L;

   private String holderName;
   private String number;
   private Date expirationDate;
   private CardBrand cardBrand;
   private String password;
   private CardType type;
   @Enumerated
   private Boolean hasPassword;

   @Override
   public Serializable getKey()
   {
      return getNumber();
   }

}
