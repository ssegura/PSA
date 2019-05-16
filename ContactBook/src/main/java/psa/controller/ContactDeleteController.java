package psa.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import psa.model.ContactRepository;
import psa.model.IContactRepository;

@WebServlet(name = "ContactDeleteController", urlPatterns = {"contactdelete"}, loadOnStartup = 1)
public class ContactDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Request data
		String id = request.getParameter("id");
		
		// Validate data
		if (id==null) {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		// Contact repository
		IContactRepository repository = ContactRepository.getInstance();
		repository.deleteContact(id);
		
		// Forward to contact list view
		request.setAttribute("message", "Contact deleted successfully");
		request.getRequestDispatcher("/contactlist").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
