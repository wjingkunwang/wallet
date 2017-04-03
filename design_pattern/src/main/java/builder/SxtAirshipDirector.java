package builder;

public class SxtAirshipDirector implements AirShipDirector {

	private AirShipBuilder builder;

	public SxtAirshipDirector(AirShipBuilder builder) {
		this.builder = builder;
	}
	public AirShip directAirShip() {
		Engine e = builder.builderEngine();
		OrbitalModule o = builder.builderOrbitalModule();

		//装配成飞船对象
		AirShip ship = new AirShip();
		ship.setEngine(e);
		ship.setOrbitalModule(o);
		
		return ship;
	}

}
