package com.embaixadaflaespanha.partnercard.persistence;

import com.embaixadaflaespanha.partnercard.payload.Partner;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import static java.lang.String.valueOf;

@Service
public class GeneralRepository {

    public Partner getPartner(Integer id) throws Exception {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("partner").document(valueOf(id));
        ApiFuture<DocumentSnapshot> future = documentReference.get();
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
