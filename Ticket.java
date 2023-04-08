package cinema;

import java.util.UUID;

public class Ticket {
    private String token ;
    private Seats ticket;
    public Ticket(Seats ticket){
        this.ticket=ticket;
        this.token=(UUID.randomUUID().toString());
    }

    public Seats getTicket() {
        return ticket;
    }

    public String getToken() {
        return token;
    }

    public void setTicket(Seats ticket) {
        this.ticket = ticket;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
