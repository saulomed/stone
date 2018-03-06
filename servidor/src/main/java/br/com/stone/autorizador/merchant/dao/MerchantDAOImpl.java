/*
* Criação : 13 de fev de 2018
*/

package br.com.stone.autorizador.merchant.dao;

import br.com.stone.autorizador.infra.dao.AbstractDAOImpl;
import br.com.stone.autorizador.merchant.entity.Merchant;

/**
 * Implementação do DAO da entidade {@link Merchant}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class MerchantDAOImpl extends AbstractDAOImpl<Long, Merchant> implements MerchantDAO
{

   public MerchantDAOImpl()
   {
      super(Merchant.class);
   }

}
