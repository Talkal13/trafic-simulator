package templates;

public class TempNewRRJunction extends Template {

	private final static String NAME = "new_rr_junction";
	private static final String USER_NAME = "New RR Junction";
	public TempNewRRJunction() {
		super(USER_NAME);
	}
	
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
