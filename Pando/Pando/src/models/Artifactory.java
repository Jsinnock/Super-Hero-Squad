package models;

import controllers.FileConfig;
/**
 * Used to create artifact objects
 *
 */
public class Artifactory {
	//creates artifacts

	public static Artifact newArtifact(String id){
		if(id.startsWith("W"))return new Weapon(FileConfig.artifactFile,id);
		if(id.startsWith("C")){return new Usable(FileConfig.artifactFile,id);}
		if(id.startsWith("I"))return new Item(FileConfig.artifactFile,id);
		System.out.println("artifact not created");
		return null;
	}
}
