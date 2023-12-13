package bridge.domain;

public class Bridge {

    private final int size;

    private Bridge(int size) {
        this.size = size;
    }

    public static Bridge from(int size) {
        return new Bridge(size);
    }

    public int getSize() {
        return size;
    }
}
