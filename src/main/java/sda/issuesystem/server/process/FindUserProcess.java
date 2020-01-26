package sda.issuesystem.server.process;

import sda.issuesystem.dto.DataTransferObject;
import sda.issuesystem.dto.User;
import sda.issuesystem.server.repository.UserRepository;

public class FindUserProcess implements ProcessInterface<User, String> {

    @Override
    public DataTransferObject<User> process(String object) {
        DataTransferObject<User> outputDTO = new DataTransferObject<>(DataTransferObject.FUBL, UserRepository.searchByLogin(object));
        return outputDTO;
    }

}
