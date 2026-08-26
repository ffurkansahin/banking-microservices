package com.furkansahin.cards.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.furkansahin.cards.constants.CardsConstants;
import com.furkansahin.cards.dto.CardsDto;
import com.furkansahin.cards.entity.Cards;
import com.furkansahin.cards.exception.CardAlreadyExistsException;
import com.furkansahin.cards.exception.ResourceNotFoundException;
import com.furkansahin.cards.mapper.CardsMapper;
import com.furkansahin.cards.repository.CardsRepository;
import com.furkansahin.cards.service.ICardsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardsService {
    
    private CardsRepository repository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCard = repository.findByMobileNumber(mobileNumber);
        if (optionalCard.isPresent()) {
            throw new CardAlreadyExistsException("Card already exists with given mobile number "+ mobileNumber); 
        } 
        repository.save(createNewCard(mobileNumber)); 
    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long rndCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(rndCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;

    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards card = repository.findByMobileNumber(mobileNumber).orElseThrow(
            () -> new ResourceNotFoundException("Card","mobileNumber", mobileNumber)
        );
        return CardsMapper.mapToCardsDto(card, new CardsDto());
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards card = repository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
            () -> new ResourceNotFoundException("Card","cardNumber", cardsDto.getCardNumber())
        );

        CardsMapper.mapToCards(cardsDto, card);
        repository.save(card);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards card = repository.findByMobileNumber(mobileNumber).orElseThrow(
            () -> new ResourceNotFoundException("Card","mobileNumber", mobileNumber)
        );
        repository.deleteById(card.getCardId());
        return true;
    }
}
