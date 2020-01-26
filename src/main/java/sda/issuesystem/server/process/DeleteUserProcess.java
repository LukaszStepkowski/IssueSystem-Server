package sda.issuesystem.server.process;

import sda.issuesystem.dto.DataTransferObject;
import sda.issuesystem.server.repository.UserRepository;

public class DeleteUserProcess implements ProcessInterface<Integer, Integer> {
    @Override
    public DataTransferObject<Integer> process(Integer object) {
        DataTransferObject<Integer> outputDTO = new DataTransferObject<>(DataTransferObject.DELU, UserRepository.removeByUserID(object));
        return outputDTO;
    }
}
