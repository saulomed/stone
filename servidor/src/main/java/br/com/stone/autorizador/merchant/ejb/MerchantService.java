/*
* Criação : 13 de fev de 2018
*/
package br.com.stone.autorizador.merchant.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import br.com.stone.autorizador.infra.builder.AbstractBuilder;
import br.com.stone.autorizador.infra.dao.DAO;
import br.com.stone.autorizador.infra.ejb.EntityService;
import br.com.stone.autorizador.merchant.builder.MerchantBuilder;
import br.com.stone.autorizador.merchant.dao.MerchantDAO;
import br.com.stone.autorizador.merchant.dto.MerchantDTO;
import br.com.stone.autorizador.merchant.entity.Merchant;

/**
 * Implementação do Service EJB para manipulação da entidate {@link Merchant}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Stateless
@Local(MerchantServiceLocal.class)
public class MerchantService extends EntityService<Merchant, Long, MerchantDTO> implements MerchantServiceLocal
{

   @Inject
   private MerchantDAO dao;

   @Inject
   private MerchantBuilder builder;

   @Override
   protected DAO<Long, Merchant> getDAO()
   {
      return dao;
   }

   @Override
   protected AbstractBuilder<MerchantDTO, Merchant> getBuilder()
   {
      return builder;
   }

}
