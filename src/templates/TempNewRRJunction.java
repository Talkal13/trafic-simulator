package templates;

public class TempNewRRJunction extends Template {

	
	public TempNewRRJunction(String name) {
		super(name);
	}

	private final String NAME = "new_rr_junction";
	
	@Override
	public String parse(String command) {
		if (command == NAME) return generateTemplate();
		return null;
	}

	@Override
	public String generateTemplate() {
		
		return "Holi";
	}

}
