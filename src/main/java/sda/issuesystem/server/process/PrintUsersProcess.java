package sda.issuesystem.server.process;

import sda.issuesystem.dto.DataTransferObject;
import sda.issuesystem.server.repository.UserRepository;

import java.util.List;

public class PrintUsersProcess implements ProcessInterface<List, List> {

    @Override
    public DataTransferObject<List> process(List object) {
        DataTransferObject<List> outputDTO = new DataTransferObject<>(DataTransferObject.GETU, UserRepository.getUserList());
        return outputDTO;
    }
}
