package sda.issuesystem.server.process;

import sda.issuesystem.dto.DataTransferObject;

public interface ProcessInterface<T> {

    DataTransferObject<T> process (T object);

}
