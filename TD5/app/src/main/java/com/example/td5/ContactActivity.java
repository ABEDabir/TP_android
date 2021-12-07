package com.example.td5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    List<Contact> contacts =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        contacts.add(new Contact("Abir", "Abed", "https://www.pourquoidocteur.fr/media/article/thunbs/uploded_istock-1002684656-1564581334.jpg"));
        contacts.add(new Contact("Jamal", "'Benali", "https://resize.prod.femina.ladmedia.fr/rblr/652,438/img/var/2015-09/comment-devenir-une-personne-solaire-0e95b16c5fefae293635ad5b6ce2b1198537e371.jpg"));
        contacts.add(new Contact("Pierre", "Menez", "https://resize-elle.ladmedia.fr/rcrop/1098,768/img/var/plain_site/storage/images/societe/news/vaimalama-chaves-je-ne-suis-pas-une-chose-mais-une-personne-3829012/92299429-1-fre-FR/Vaimalama-Chaves-Je-ne-suis-pas-une-chose-mais-une-personne.jpg"));
        contacts.add(new Contact("Arthur", "Rimbaut", "https://i2.wp.com/movingtahiti.com/wp-content/uploads/2021/04/liar-7-11-16.jpg?fit=1050%2C700&ssl=1"));
        contacts.add(new Contact("rick", "fromager", "https://i2.wp.com/movingtahiti.com/wp-content/uploads/2021/04/how-spot-liar.jpg?resize=1536%2C1024&ssl=1"));
        contacts.add(new Contact("hmida", "hamid", "https://i0.wp.com/movingtahiti.com/wp-content/uploads/2021/04/personne-mauvaise.jpg?w=749&ssl=1"));
        contacts.add(new Contact("said", "ghalimi", "https://laviedesreines.com/wp-content/uploads/2019/05/tes-vous-sapiophile-15-signes-qui-prouvent-que-vous-%C3%AAtes-une-personne-sapiosexuelle-e1559773514993.jpg"));
        contacts.add(new Contact("fatima", "khadija", "https://resize.prod.femina.ladmedia.fr/rblr/652,438/img/var/2015-09/comment-devenir-une-personne-solaire-0e95b16c5fefae293635ad5b6ce2b1198537e371.jpg"));
        contacts.add(new Contact("Pierre", "Menez", "https://resize-elle.ladmedia.fr/rcrop/1098,768/img/var/plain_site/storage/images/societe/news/vaimalama-chaves-je-ne-suis-pas-une-chose-mais-une-personne-3829012/92299429-1-fre-FR/Vaimalama-Chaves-Je-ne-suis-pas-une-chose-mais-une-personne.jpg"));

        ContactsAdapter adapter = new ContactsAdapter(contacts);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

    }
}