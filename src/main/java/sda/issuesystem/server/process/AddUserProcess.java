package sda.issuesystem.server.process;

import sda.issuesystem.dto.DataTransferObject;
import sda.issuesystem.dto.User;
import sda.issuesystem.server.repository.UserRepository;

public class AddUserProcess implements ProcessInterface<User> {

    @Override
    public DataTransferObject<User> process(User user) {
        UserRepository.USER_LIST.add(user);
        return new DataTransferObject<>(DataTransferObject.ADU, user);
    }
}
