package sda.issuesystem.server.process;

import sda.issuesystem.dto.DataTransferObject;

public class ProcessFactory {

    public static <T> ProcessInterface<?> processChoice (DataTransferObject<T> dto){

        switch (dto.getProcessName()){
            case DataTransferObject.ADU:
                return new AddUserProcess();

            case DataTransferObject.DELU:
//                UserRepository.removeByUserID();
                break;

            case DataTransferObject.FUBL:
//                UserRepository.searchByLogin();
                break;

            case DataTransferObject.GETU:
                return new PrintUsersProcess();
        }

        return null;
    }

}
