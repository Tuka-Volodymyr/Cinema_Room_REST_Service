package cinema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class TheaterController {
    private final Cinema cinema=new Cinema(9,9);
    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }
    @PostMapping("/purchase")
    public ResponseEntity<?> postPurchase(@RequestBody Seats seats) {
        int row = seats.getRow();
        int column = seats.getColumn();
        for(int i=0;i<cinema.getSeatIs().size();i++){
            seats=cinema.getSeatIs().get(i);
            if(seats.getRow()==row&&seats.getColumn()==column){
                Ticket ticket=new Ticket(seats);
                cinema.buyTicket(seats,ticket);
                return new ResponseEntity<>(ticket,HttpStatus.OK);
            }
        }
        if (row > 9 || column > 9 || row < 1 || column < 1) {
            return new ResponseEntity<>(Map.of( "error", "The number of a row or a column is out of bounds!" ), HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(Map.of( "error", "The ticket has been already purchased!" ), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/return")
    public ResponseEntity<?> postReturn(@RequestBody String token){
        token = token.split(":")[1];
        token = token.substring(1, token.length() - 2);
        if(cinema.getPurchasedTickets().containsKey(token)){
            Seats seats=cinema.getPurchasedTickets().get(token);
            cinema.returnTicket(seats,token);
            return new ResponseEntity<>(Map.of("returned_ticket",seats),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(Map.of("error","Wrong token!"),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/stats")
    public ResponseEntity<?> statsReturn(@RequestParam(value = "password",required = false) String password ) {
        if(password==null) {
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
        }
        Statistics statistics = new Statistics(cinema);
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}
