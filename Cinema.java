package cinema;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Getter
@Setter
public class Cinema {
    @JsonProperty("total_rows")
    private int rows;
    @JsonProperty("total_columns")
    private int cols;
    @JsonProperty("available_seats")
    private List<Seats> seatIs;
    @JsonIgnore
    private Map<String, Seats> purchasedTickets;
    @JsonIgnore
    private int totalIncome;
    public Cinema(int rows,int cols){
        this.rows=rows;
        this.cols=cols;
        this.totalIncome=0;
        this.seatIs=new ArrayList<>();
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                seatIs.add(new Seats(i,j));
            }
        }
        this.purchasedTickets = new HashMap<>();
    }
    public void buyTicket(Seats seats,Ticket ticket){
        seatIs.remove(seats);
        purchasedTickets.put(ticket.getToken(),ticket.getTicket());
        totalIncome+=seats.getPrice();
    }
    public void returnTicket(Seats seat, String token) {
        purchasedTickets.remove(token);
        seatIs.add(seat);
        totalIncome-=seat.getPrice();
    }
    public List<Seats> getSeatIs() {
        return seatIs;
    }
    public void setSeatIs(List<Seats> seatIs) {
        this.seatIs = seatIs;
    }

    public Map<String, Seats> getPurchasedTickets() {
        return purchasedTickets;
    }
    public int getTotalIncome() {
        return totalIncome;
    }
}
