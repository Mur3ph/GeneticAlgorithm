package ie.murph.java.interfaces;

public interface ConsoleTextVariables 
{
	//Constant variables used throughout the application
	public final static String STARTING = "*** STARTING *** GENERATIN THE RANDON FITNESS VALUES INTO AN ARRAY.!";
	public final static String PHASE_ONE = "1). My Map with the random fitness values 1 - Unorganised fitness: ";
	public final static String PHASE_TWO = "2). My Map with the random fitness values 2 - Organised fittest: ";
	public final static String PHASE_THREE = "3). Finding the total fitness number of all the combined data: ";
	public final static String PHASE_FOUR = "4). Dividing each individual fitness value by the total - Calculating Normalized data ";
	public final static String PHASE_FIVE = "5). Adding the normalised data to get the Cumulative frequency: ";
	public final static String PHASE_SIX = "6). Choose a random number between 0 - 1 to select which fitnesses should be used: ";
	public final static String PHASE_SEVEN = "7). Compare numbers between(0,1) against cumulative frequency: ";
	public final static String PHASE_EIGHT = "8). From the random number chosen between (0-1) Get the integer value[P] representation in the same position of the cumulative frequency number chosen at random: ";
	public final static String PHASE_NINE = "9). CROSSOVER of both binary strings: ";
	public final static String PHASE_TEN = "10). Mutation of offspring string: ";
	public final static String PHASE_ELEVEN = "11). Convert the offspring back to an Integer: ";
	public final static String PHASE_TWELVE = "12). Send the two new fitness to the random generator method and receive them back here for next generation: ";
	public final static String BREAK_DIVIDER = "###################################################################";
	public final static String ASK_HOW_MANY_HUMAN_GENERATIONS_USER_WANTS_TO_CLACULATE = "How many generations do you want to calculate.!";
}
