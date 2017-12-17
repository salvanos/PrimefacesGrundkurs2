package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named
@RequestScoped
public class ImageController {
	public void persist(FileUploadEvent event) throws IOException {
		UploadedFile file = event.getFile();
		String fileName = file.getFileName();
		
		Files.copy(
			file.getInputstream(),
			Paths.get("/tmp/" + fileName),
			StandardCopyOption.REPLACE_EXISTING);
		
		FacesContext.getCurrentInstance().addMessage(
			null,
			new FacesMessage("Hochgeladen: " + fileName));
		
	}
}
