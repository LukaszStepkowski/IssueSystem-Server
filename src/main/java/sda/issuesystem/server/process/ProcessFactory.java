package sda.issuesystem.server.process;

import sda.issuesystem.dto.DataTransferObject;
import sda.issuesystem.dto.User;
import sda.issuesystem.server.repository.UserRepository;

public class ProcessFactory {

    public static <T> ProcessInterface<T> processChoice (DataTransferObject<T> dto){

        switch (dto.getProcessName()){
            case DataTransferObject.ADU:
                return (ProcessInterface<T>) new AddUserProcess().process((User) dto.getObject());

            case DataTransferObject.DELU:
//                UserRepository.removeByUserID();
                break;

            case DataTransferObject.FUBL:
//                UserRepository.searchByLogin();
                break;

            case DataTransferObject.GETU:
                break;
        }

        return null;
    }

}
