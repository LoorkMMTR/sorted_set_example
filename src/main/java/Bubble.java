import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bubble implements Comparable<Bubble> {
    int diameter;
    String colour;

    @Override
    public int compareTo(Bubble o) {
        return this.diameter - o.diameter;
    }
}
