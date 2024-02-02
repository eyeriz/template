package com.iris.msirismicroservicetemplate.utils;

import lombok.Setter;
import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Setter()
@Accessors(chain = true)
@Component
public class Logging {
    Object logMessage;
    Object responseCode;
    String targetSystem;
    String targetEndpoint;
    String processName;
    String operationName;
    String sourceSystem;
    String logType;
    String logLevel;
    String logStatus;
    String sourceIp;
    String processId;
    Object transactionCost;


    private static final Logger logger = LoggerFactory.getLogger(Logging.class);
    private static final String TITLES = "LogMessage={} | ResponseCode={} |TargetSystem={} | TargetEndpoint={} | ProcessName={} | OperationName={} | SourceSystem={} | LogType={} | LogLevel={} | LogStatus={} | SourceIp={} | ProcessIp={} | TransactionCost={}";

    @Async
    public void write() {
        switch (logLevel) {
            case "warn": {
                logger.warn(
                        TITLES,
                        logMessage, responseCode, targetSystem, targetEndpoint, processName, operationName, sourceSystem, logType, logLevel,logStatus,sourceIp,processId,transactionCost
                );
                break;
            }
            case "error": {
                logger.error(
                        TITLES,
                        logMessage, responseCode, targetSystem, targetEndpoint, processName, operationName, sourceSystem, logType, logLevel,logStatus,sourceIp,processId,transactionCost
                );
                break;
            }
            default: {
                logger.info(
                        TITLES,
                        logMessage, responseCode, targetSystem, targetEndpoint, processName, operationName, sourceSystem, logType, logLevel,logStatus,sourceIp,processId,transactionCost
                );
                break;
            }
        }
    }

    public void writeInfoLog(String message, String process, String response, String targetSystem, String processName, String sourceSystem){

        logger.error("LogMessage=Thread: {} : {} PROCESS: {} Exception: {} | ResponseCode=00 | TargetEndpoint= {} |TargetSystem= {} | ProcessName= {} | OperationName=Request in | SourceSystem = {} | LogType=Request-in | LogStatus=STARTING | LogLevel= ERROR |SourceIP= | TransactionCost=0 |ProcessId= {}", Thread.currentThread().getId(),  message, process, response, targetSystem, targetSystem, processName, sourceSystem, processName);


    }
}
