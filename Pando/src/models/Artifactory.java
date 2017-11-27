package models;

import controllers.FileConfig;

public class Artifactory {
	//creates artifacts

	public static Artifact newArtifact(String id){
		if(id.startsWith("W"))return new Weapon(FileConfig.artifactFile,id);
		if(id.startsWith("C")){
			System.out.println("usable");
			return new Usable(FileConfig.artifactFile,id);
		}
		if(id.startsWith("I"))return new Item(FileConfig.artifactFile,id);
		System.out.println("no");
		return null;
	}
}
