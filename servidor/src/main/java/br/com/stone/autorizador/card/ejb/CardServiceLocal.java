/*
* Criação : 28 de jan de 2018
*/
package br.com.stone.autorizador.card.ejb;

import javax.ejb.Local;
import br.com.stone.autorizador.card.dto.CardDTO;
import br.com.stone.autorizador.card.entity.Card;
import br.com.stone.autorizador.infra.ejb.EntityServiceLocal;

/**
 * Entidade Local para o service da entidade {@link Card}
 * 
 * @author Janeiro/2018: Saulo Santos
 *         <DD>
 */
@Local
public interface CardServiceLocal extends EntityServiceLocal<Card, String, CardDTO>
{

}
