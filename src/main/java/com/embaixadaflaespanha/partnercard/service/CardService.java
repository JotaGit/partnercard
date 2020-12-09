package com.embaixadaflaespanha.partnercard.service;

import com.embaixadaflaespanha.partnercard.payload.Partner;
import com.embaixadaflaespanha.partnercard.persistence.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final PartnerRepository generalRepository;

    public Partner getCardForPartner(Integer id) throws Exception {

        return generalRepository.getPartner(id);
    }
}
