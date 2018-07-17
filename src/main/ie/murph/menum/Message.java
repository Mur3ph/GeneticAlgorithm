package main.ie.murph.menum;

public enum Message {

		STARTING_GENETIC_ALGORITHM("*** STARTING *** GENERATING THE RANDOM FITNESS VALUES INTO AN ARRAY.!"),
		ASK_HOW_MANY_HUMAN_GENERATIONS_USER_WANTS_TO_CLACULATE("How many generations do you want to calculate.!");

	    private final String text;

	    private Message(final String text) 
	    {
	        this.text = text;
	    }

	    @Override
	    public String toString() 
	    {
	        return text;
	    }
	
}
