package com.embaixadaflaespanha.partnercard.controller;

import com.embaixadaflaespanha.partnercard.payload.Partner;
import com.embaixadaflaespanha.partnercard.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Partner getPartner(@PathVariable String id) throws Exception {
        return cardService.getCardForPartner(Integer.valueOf(id));
    }
}
