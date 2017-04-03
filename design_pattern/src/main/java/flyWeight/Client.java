package flyWeight;

public class Client {
    public static void main(String[] args) {
        ChessFlyweightFactory factory = new ChessFlyweightFactory();
        ChessFlyweight chess1 = factory.getChess("黑色");
        ChessFlyweight chess2 = factory.getChess("黑色");
        System.out.println(chess1);
        System.out.println(chess2);

        System.out.println("增加外部状态的处理===========");
        chess1.display(new Coordinate(10, 10));
        chess2.display(new Coordinate(20, 20));
    }
}
