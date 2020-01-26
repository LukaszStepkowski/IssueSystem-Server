package sda.issuesystem.server.process;

import sda.issuesystem.dto.DataTransferObject;

public interface ProcessInterface<T, V> {

    DataTransferObject<T> process (V object);

}
