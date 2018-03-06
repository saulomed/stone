/*
* Criação : 13 de fev de 2018
*/
package br.com.stone.autorizador.merchant;

import javax.naming.NamingException;
import org.junit.Assert;
import org.junit.Test;
import br.com.stone.autorizador.infra.AbstractTest;
import br.com.stone.autorizador.merchant.dto.MerchantDTO;
import br.com.stone.autorizador.merchant.ejb.MerchantServiceLocal;
import br.com.stone.autorizador.merchant.entity.Merchant;

/**
 * Classe de teste para validação de serviço da entidade {@link Merchant}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class MerchantServiceTest extends AbstractTest
{

   private MerchantServiceLocal service;

   /**
    * Teste para validação de inserção e deleção da entidade
    * 
    * @throws NamingException
    */
   @Test
   public void testInsertDelete() throws NamingException
   {
      MerchantDTO dto = createMechantDefault();

      dto = getService().save(dto);

      Assert.assertNotNull(dto);
      Assert.assertNotNull(dto.getId());

      Merchant entity = getService().searchById(dto.getKey());
      Assert.assertNotNull(entity);
      Assert.assertEquals(dto.getId(), entity.getKey());
      Assert.assertEquals(dto.getName(), entity.getName());

      getService().delete(dto);
      entity = getService().searchById(dto.getKey());
      Assert.assertNull(entity);

   }

   /**
    * Teste de validação para atualização da entidade
    * 
    * @throws NamingException
    */
   @Test
   public void testUpdate() throws NamingException
   {
      MerchantDTO dto = createMechantDefault();

      dto = getService().save(dto);

      String name = "TESTE UPDATE";
      dto.setName(name);
      getService().update(dto);

      Merchant entity = getService().searchById(dto.getKey());
      Assert.assertNotNull(entity);
      Assert.assertEquals(dto.getId(), entity.getKey());
      Assert.assertEquals(entity.getName(), name);

   }

   public MerchantServiceLocal getService() throws NamingException
   {
      if (service == null)
      {
         service = (MerchantServiceLocal) getContext().lookup("MerchantServiceLocal");
      }

      return service;
   }

}
