package flyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 * @author Administrator
 *
 */
public class ChessFlyweightFactory {
	//享元池
	private static Map<String,ChessFlyweight> map = new HashMap<String, ChessFlyweight>();
	
	public ChessFlyweight getChess(String color){
		
		if(map.get(color)!=null){
			return map.get(color);
		}else{
			ChessFlyweight cfw = new ConcreteChess(color);
			map.put(color, cfw);
			return cfw;
		}
		
	}

}
