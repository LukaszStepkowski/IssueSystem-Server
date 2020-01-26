package sda.issuesystem.server.process;

import sda.issuesystem.dto.DataTransferObject;

public class ProcessFactory {

    public static <T> ProcessInterface<?,?> processChoice (DataTransferObject<T> dto){

        switch (dto.getProcessName()){
            case DataTransferObject.ADU:
                return new AddUserProcess();

            case DataTransferObject.DELU:
                return new DeleteUserProcess();

            case DataTransferObject.FUBL:
                return new FindUserProcess();

            case DataTransferObject.GETU:
                return new PrintUsersProcess();
        }

        return null;
    }

}
