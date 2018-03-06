/*
* Criação : 4 de mar de 2018
*/
package br.com.stone.autorizador.infra.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import br.com.stone.autorizador.card.dto.CardDTO;
import br.com.stone.autorizador.card.ejb.CardServiceLocal;
import br.com.stone.autorizador.card.enums.CardBrand;
import br.com.stone.autorizador.card.enums.CardType;
import br.com.stone.autorizador.merchant.dto.MerchantDTO;
import br.com.stone.autorizador.merchant.ejb.MerchantServiceLocal;
import br.com.stone.autorizador.transaction.dto.TransactionDTO;
import br.com.stone.autorizador.transaction.enums.TransactionType;

/**
 * Classe statup responsavel pela criação do calatolo de cartões para testes com a camada web
 * 
 * @author Março/2018: Saulo Santos
 *         <DD>
 */
@Startup
@Singleton
public class SetUp
{

   @EJB
   private CardServiceLocal cardService;

   @EJB
   private MerchantServiceLocal merchantService;

   @PostConstruct
   public void init() throws ParseException
   {

      CardDTO card = createCardDefault();
      cardService.save(card);
      MerchantDTO merchant = createMechantDefault();
      merchantService.save(merchant);
      card = createCardTransactionFault();
      cardService.save(card);
      card = createCardNoBalance();
      cardService.save(card);
   }

   protected TransactionDTO criaTransacaoPadrao(CardDTO card, BigDecimal amount, TransactionType type, Integer parcel, MerchantDTO merch)
   {
      TransactionDTO dto = new TransactionDTO();
      dto.setAmount(amount);
      dto.setCard(card);
      dto.setType(type);
      dto.setNumber(parcel);
      dto.setMerchant(merch);

      return dto;
   }

   /**
    * Metodo responsável por criar um cartão padrão para utilização nos testes
    * 
    * @return
    * @throws ParseException
    */
   protected CardDTO createCardDefault() throws ParseException
   {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      CardDTO card = new CardDTO();
      card.setHolderName("SAULO SANTOS");
      card.setNumber("12345678912345");
      card.setExpirationDate(sdf.parse("30/12/2018"));
      card.setCardBrand(CardBrand.VISA);
      card.setPassword("123987");
      card.setType(CardType.MAGNETIC);
      card.setHasPassword(true);
      return card;
   }

   /**
    * Metodo responsável por criar um cartão padrão para utilização nos testes
    * 
    * @return
    * @throws ParseException
    */
   protected CardDTO createCardTransactionFault() throws ParseException
   {
      CardDTO card = createCardDefault();
      card.setNumber("12345678912346");
      return card;
   }

   /**
    * Metodo responsável por criar um cartão padrão para utilização nos testes
    * 
    * @return
    * @throws ParseException
    */
   protected CardDTO createCardNoBalance() throws ParseException
   {
      CardDTO card = createCardDefault();
      card.setNumber("12345678912347");

      return card;
   }

   protected MerchantDTO createMechantDefault()
   {
      MerchantDTO dto = new MerchantDTO();
      dto.setName("ESTABELECIMENTO TESTE");
      return dto;
   }

}
