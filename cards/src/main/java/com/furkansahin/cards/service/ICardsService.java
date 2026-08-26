package com.furkansahin.cards.service;

import com.furkansahin.cards.dto.CardsDto;

public interface ICardsService {
    
    void createCard(String mobileNumber);

    CardsDto fetchCard(String mobileNumber);

    boolean updateCard(CardsDto cardsDto);

    boolean deleteCard(String mobileNumber);
}
