package ie.murph.java.main.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class MyLogger
{
    private final static Logger LOGGER = Logger.getLogger(MyLogger.class);
    
    public static void main(String[] args)
    {
	configureLoggingToRun();
	MyLogger myLogger = new MyLogger();
	myLogger.runLogging("pauly o muiricú");
    }

    private static void configureLoggingToRun()
    {
//	Use BasicConfigurator to help run configure Log4j properly - will give error without it. //http://stackoverflow.com/questions/12532339/no-appenders-could-be-found-for-loggerlog4j
	BasicConfigurator.configure();
    }

    private void runLogging(String parameter)
    {
	if(LOGGER.isDebugEnabled())
	{
		LOGGER.debug("This is debug log: " + parameter);
	}

	if(LOGGER.isInfoEnabled())
	{
		LOGGER.info("This is info log: " + parameter);
	}
	
	if(LOGGER.isTraceEnabled())
	{
		LOGGER.trace("This is trace log: " + parameter);
	}

	LOGGER.warn("This is warn log: " + parameter);
	LOGGER.error("This is error log: " + parameter);
	LOGGER.fatal("This is fatal log: " + parameter);

    }
}
