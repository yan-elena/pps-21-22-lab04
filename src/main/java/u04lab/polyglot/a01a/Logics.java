package u04lab.polyglot.a01a;

public interface Logics {

    enum Result {
        HIT, MISS, WON, LOST
    }

    Result hit(int row, int col);

}

