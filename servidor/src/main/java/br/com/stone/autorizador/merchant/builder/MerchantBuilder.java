/*
* Criação : 13 de fev de 2018
*/
package br.com.stone.autorizador.merchant.builder;

import br.com.stone.autorizador.infra.builder.AbstractBuilder;
import br.com.stone.autorizador.merchant.dto.MerchantDTO;
import br.com.stone.autorizador.merchant.entity.Merchant;

/**
 * Classe responsável pela criação de classes de transporte da entidade {@link Merchant}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class MerchantBuilder extends AbstractBuilder<MerchantDTO, Merchant>
{

   @Override
   public void fillEntity(MerchantDTO dto, Merchant entity) throws RuntimeException
   {
      entity.setId(dto.getId());
      entity.setName(dto.getName());
   }

   @Override
   public MerchantDTO createDTO(Merchant entity)
   {
      MerchantDTO dto = new MerchantDTO();
      dto.setId(entity.getId());
      dto.setName(entity.getName());
      return dto;
   }

}
