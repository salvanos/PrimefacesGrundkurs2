package de.java2enterprise.onlineshop;

import java.io.ByteArrayInputStream;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named
@RequestScoped
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;

	public StreamedContent getFile() {
		FacesContext context = 
				FacesContext.getCurrentInstance();
		
		if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			String id = 
				context
				.getExternalContext()
				.getRequestParameterMap()
				.get("itemId");
			
			Query query = em.createQuery( 
				"select i.foto "
				+ "from Item i "
				+ "where i.id = :id");
			query.setParameter("id", Long.parseLong(id));
			byte[] foto = (byte[])query.getSingleResult();
			
			return new DefaultStreamedContent(new ByteArrayInputStream(foto));
		}
	}
}
