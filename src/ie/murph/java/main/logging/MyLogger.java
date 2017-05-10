package ie.murph.java.main.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class MyLogger
{
    private final static Logger LOGGER = Logger.getLogger(MyLogger.class);
    
    public static void main(String[] args)
    {
//	Use BasicConfigurator to help run configure Log4j properly - will give error without it. //http://stackoverflow.com/questions/12532339/no-appenders-could-be-found-for-loggerlog4j
	BasicConfigurator.configure();
	
	MyLogger obj = new MyLogger();
	obj.runMe("pauly");

    }

    private void runMe(String parameter)
    {
	if(LOGGER.isDebugEnabled()){
		LOGGER.debug("This is debug : " + parameter);
	}

	if(LOGGER.isInfoEnabled()){
		LOGGER.info("This is info : " + parameter);
	}

	LOGGER.warn("This is warn : " + parameter);
	LOGGER.error("This is error : " + parameter);
	LOGGER.fatal("This is fatal : " + parameter);

    }
}
