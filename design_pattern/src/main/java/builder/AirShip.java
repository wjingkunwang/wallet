package builder;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 尚学堂牌宇宙飞船
 * @author 尚学堂高淇 www.sxt.cn
 *
 */
@Data
public class AirShip {
	
	private OrbitalModule orbitalModule;  //轨道舱
	private Engine engine; //发动机

	public void launch(){
		System.out.println("发射！");
	}
}

@Data
@AllArgsConstructor
class OrbitalModule{
	private String name;
}

@Data
@AllArgsConstructor
class Engine {
	private String name;
}



