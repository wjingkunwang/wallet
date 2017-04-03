package builder;


public class SxtAirShipBuilder implements AirShipBuilder {
	//StringBuilder, 以后学习XML解析中，JDOM库中的类：DomBuilder,SaxBuilder
	public Engine builderEngine() {
		System.out.println("构建发动机！");
		return new Engine("发动机！");
	}

	public OrbitalModule builderOrbitalModule() {
		System.out.println("构建轨道舱");
		return new OrbitalModule("轨道舱");
	}	
	
}
