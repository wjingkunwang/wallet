package mediator;

public class Client {
	public static void main(String[] args) {
		President mediator = new President();
		Market   market = new Market(mediator);
		Development development = new Development(mediator);
		Financial financial = new Financial(mediator);

		mediator.setFinancial(financial);
		mediator.setDevelopment(development);
		mediator.setMarket(market);

		market.selfAction();
		market.outAction();
	}
}
