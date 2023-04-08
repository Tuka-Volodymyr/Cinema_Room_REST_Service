package cinema;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seats {
    private int row;
    private int column;
    private int price;
    public Seats(int row, int column) {
        if(row<=4){
            price=10;
        }else {
            price=8;
        }
        this.column = column;
        this.row = row;
    }
    public int getPrice() {
        return price;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

}
