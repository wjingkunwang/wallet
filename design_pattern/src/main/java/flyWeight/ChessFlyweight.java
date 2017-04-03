package flyWeight;

/**
 * 享元类
 *
 * @author Administrator
 */
public interface ChessFlyweight {
    void setColor(String c);

    String getColor();

    void display(Coordinate c);

}



