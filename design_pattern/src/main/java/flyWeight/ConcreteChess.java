package flyWeight;

/**
 * Created by wjk on 16/7/7.
 */
class ConcreteChess implements ChessFlyweight {

    private String color;

    public ConcreteChess(String color) {
        super();
        this.color = color;
    }

    public void display(Coordinate c) {
        System.out.println("棋子位置：" + c.getX() + "----" + c.getY());
        System.out.println("棋子颜色：" + color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String c) {
        this.color = c;
    }

}
