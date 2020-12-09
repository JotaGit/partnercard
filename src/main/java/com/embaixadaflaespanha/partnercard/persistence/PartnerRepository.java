package com.embaixadaflaespanha.partnercard.persistence;

import com.embaixadaflaespanha.partnercard.payload.Partner;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.valueOf;

@RequiredArgsConstructor
@Service
public class PartnerRepository {

    private final Firestore firestore;

    public Partner getPartner(Integer id) throws Exception {

        ApiFuture<DocumentSnapshot> future =
                firestore.collection("partner")
                        .document(valueOf(id))
                        .get();
        DocumentSnapshot document = future.get();

        if(document.exists()) {
            Partner partner = document.toObject(Partner.class);
            partner.setId(Integer.valueOf(document.getId()));
            return partner;
        }else {
            return null;
        }
    }

}
