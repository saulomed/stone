/*
* Criação : 13 de fev de 2018
*/
package br.com.stone.autorizador.merchant.ejb;

import javax.ejb.Local;
import br.com.stone.autorizador.infra.ejb.EntityServiceLocal;
import br.com.stone.autorizador.merchant.dto.MerchantDTO;
import br.com.stone.autorizador.merchant.entity.Merchant;

/**
 * Entidade Local para o service da entidade {@link Merchant}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Local
public interface MerchantServiceLocal extends EntityServiceLocal<Merchant, Long, MerchantDTO>
{

}
