package my.rest.api.git;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import bean.InputBean;
import my.rest.api.utils.ApiRestPropertiesUtil;

public class GitOperationService implements IGitOperationService {
    
	//Inject service containing configurations
	
	public void pushFile(InputBean[] inputFile){

		 
		try {
			// prepare a new folder for the cloned repository
			File localPath = File.createTempFile("WebAppTempRep", "");
			// then clone
		    if (!localPath.exists() && !localPath.isDirectory()) {
		        localPath.mkdir();
		    }
		    localPath.delete();
		    
			Git git = Git.cloneRepository().setURI(ApiRestPropertiesUtil.getInstance().getGiturl())
					.setCredentialsProvider(new UsernamePasswordCredentialsProvider(ApiRestPropertiesUtil.getInstance().getGituser(), ApiRestPropertiesUtil.getInstance().getGitpassword()))
					.setDirectory(localPath)
					.call();
			Repository repository = git.getRepository();
			// create the folder
			File theDir = new File(repository.getDirectory().getParent(), ApiRestPropertiesUtil.getInstance().getGitdirupload()+"/"+System.currentTimeMillis());
			theDir.mkdir();

			// create the file
			for(InputBean inputbean : inputFile){
				 System.out.println("file name :"+inputbean.getName()+" ; file content :"+inputbean.getContent());
				File myfile = new File(theDir, inputbean.getName() + ".txt");
				// Writes a string to the above temporary file
				Files.write(myfile.toPath(), inputbean.getContent().getBytes(StandardCharsets.UTF_8));
			}

			// Stage all files in the repo including new files
			git.add().addFilepattern(".").call();

			// and then commit the changes.
			git.commit().setMessage("Commit current file").call();

			// Stage all changed files, omitting new files, and commit with one
			// command
			git.commit().setAll(true).setMessage("Commit changes to all files").call();
			git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider(ApiRestPropertiesUtil.getInstance().getGituser(), ApiRestPropertiesUtil.getInstance().getGitpassword())).call();
			git.close();
		} catch (InvalidRemoteException e) {
			System.out.println("GitOperationService InvalidRemoteException ");
		} catch (TransportException e) {
			System.out.println("GitOperationService TransportException ");
		} catch (NoFilepatternException e) {
			System.out.println("GitOperationService NoFilepatternException ");
		} catch (NoHeadException e) {
			System.out.println("GitOperationService NoHeadException ");
		} catch (NoMessageException e) {
			System.out.println("GitOperationService NoMessageException ");
		} catch (UnmergedPathsException e) {
			System.out.println("GitOperationService UnmergedPathsException ");
		} catch (ConcurrentRefUpdateException e) {
			System.out.println("GitOperationService ConcurrentRefUpdateException ");
		} catch (WrongRepositoryStateException e) {
			System.out.println("GitOperationService WrongRepositoryStateException ");
		} catch (IOException e) {
			System.out.println("GitOperationService IOException ");
		} catch (GitAPIException e) {
			System.out.println("GitOperationService GitAPIException ");
		}

	}
	
}
