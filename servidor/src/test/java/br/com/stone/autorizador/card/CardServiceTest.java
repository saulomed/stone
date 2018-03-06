/*
* Criação : 28 de jan de 2018
*/

package br.com.stone.autorizador.card;

import java.text.ParseException;
import java.util.List;
import javax.ejb.EJBTransactionRolledbackException;
import javax.naming.NamingException;
import org.junit.Assert;
import org.junit.Test;
import br.com.stone.autorizador.card.dto.CardDTO;
import br.com.stone.autorizador.card.ejb.CardServiceLocal;
import br.com.stone.autorizador.card.entity.Card;
import br.com.stone.autorizador.infra.AbstractTest;

/**
 * Classe de teste para validação de serviço da entidade {@link Card}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class CardServiceTest extends AbstractTest
{

   private CardServiceLocal service;

   /**
    * teste para inserção de cartão
    * 
    * @throws ParseException
    * @throws NamingException
    */
   @Test
   public void test1() throws ParseException, NamingException
   {

      System.out.println("-----------TESTE 1-----------------");
      CardDTO card = createCardDefault();

      getService().save(card);

      Card cBase = getService().searchById(card.getKey());

      Assert.assertNotNull(cBase);

      Assert.assertEquals(cBase.getNumber(), card.getNumber());
      getService().delete(card);
      System.out.println("-----------FIM-----------------");

   }

   /**
    * Teste de validação de remoção de cartão
    * 
    * @throws ParseException
    * @throws NamingException
    */
   @Test
   public void test2() throws ParseException, NamingException
   {
      System.out.println("-----------TESTE 2-----------------");
      CardDTO card = createCardDefault();
      getService().save(card);

      Card cBase = getService().searchById(card.getKey());

      Assert.assertNotNull(cBase);

      Assert.assertEquals(cBase.getNumber(), card.getNumber());

      getService().delete(card);

      cBase = service.searchById(card.getKey());
      Assert.assertNull(cBase);
      System.out.println("-----------FIM-----------------");
   }

   /**
    * Teste de validação de atualização de dados do cartão
    * 
    * @throws ParseException
    * @throws NamingException
    */
   @Test
   public void test3() throws ParseException, NamingException
   {
      System.out.println("-----------TESTE 3-----------------");
      CardDTO card = createCardDefault();
      getService().save(card);

      Card cBase = getService().searchById(card.getKey());

      Assert.assertNotNull(cBase);

      Assert.assertEquals(cBase.getNumber(), card.getNumber());
      
      String newName = "NOVO NOME";
      card.setHolderName(newName);

      getService().update(card);

      cBase = service.searchById(card.getKey());
      Assert.assertNotNull(cBase);

      Assert.assertEquals(cBase.getNumber(), card.getNumber());
      Assert.assertEquals(cBase.getHolderName(), newName);
      getService().delete(card);
      System.out.println("-----------FIM-----------------");
   }

   @Test(expected = EJBTransactionRolledbackException.class)
   public void test4() throws ParseException, NamingException
   {
      System.out.println("-----------TESTE 4-----------------");
      CardDTO card = createCardDefault();
      card.setNumber("12345678901234567890");
      getService().save(card);

   }

   public void clearTable() throws NamingException
   {
      List<Card> cards = getService().findAll();

      if (cards != null && !cards.isEmpty())
      {
         for (Card card : cards)
         {
            // getService().delete(dto)
         }
      }

   }

   public CardServiceLocal getService() throws NamingException
   {
      if (service == null)
      {
         service = (CardServiceLocal) getContext().lookup("CardServiceLocal");
      }

      return service;
   }
}
