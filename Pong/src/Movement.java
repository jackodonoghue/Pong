public abstract class Movement implements Moveable {

    @Override
    public void up(int y) {
        y = 20;
    }

    @Override
    public void down(int y) {
        y = -20;
    }
}
