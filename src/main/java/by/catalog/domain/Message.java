package by.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message {

    private long id;
    private long idAdvert;
    private long idUser;
    private String nameUser;
    private String body;
    private String date;

    public Message(long idAdvert, long idUser, String body, String date) {
        this.idAdvert = idAdvert;
        this.idUser = idUser;
        this.body = body;
        this.date = date;
    }

    public Message(long id, long idAdvert, String nameUser, String body, String date) {
        this.id = id;
        this.idAdvert = idAdvert;
        this.nameUser = nameUser;
        this.body = body;
        this.date = date;
    }

    public Message(long id, long idAdvert, long idUser, String body, String date) {
        this.id = id;
        this.idAdvert = idAdvert;
        this.idUser = idUser;
        this.body = body;
        this.date = date;
    }

}
