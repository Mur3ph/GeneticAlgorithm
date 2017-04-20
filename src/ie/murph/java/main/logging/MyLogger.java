package ie.murph.java.main.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class MyLogger
{
    private final static Logger logger = Logger.getLogger(MyLogger.class);
    
    public static void main(String[] args)
    {
//	Use BasicConfigurator to help run configure Log4j properly - will give error without it. //http://stackoverflow.com/questions/12532339/no-appenders-could-be-found-for-loggerlog4j
	BasicConfigurator.configure();
	
	MyLogger obj = new MyLogger();
	obj.runMe("pauly");

    }

    private void runMe(String parameter)
    {
	if(logger.isDebugEnabled()){
		logger.debug("This is debug : " + parameter);
	}

	if(logger.isInfoEnabled()){
		logger.info("This is info : " + parameter);
	}

	logger.warn("This is warn : " + parameter);
	logger.error("This is error : " + parameter);
	logger.fatal("This is fatal : " + parameter);

    }
}
