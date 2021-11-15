package com.CodersCampus.Assignment4;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileService {
	public User[] createStudentsFromMasterFile();

	public void writeToFile(File file, List<User> students) throws IOException;
}
