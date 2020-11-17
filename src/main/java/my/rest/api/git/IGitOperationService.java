package my.rest.api.git;

import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;

import bean.InputBean;

public interface IGitOperationService {
	
	void pushFile(InputBean[] inputFile) ;
	
}
