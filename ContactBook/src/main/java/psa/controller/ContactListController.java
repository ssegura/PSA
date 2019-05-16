package psa.controller;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import psa.model.Contact;
import psa.model.ContactRepository;
import psa.model.IContactRepository;

@WebServlet(name = "ContactListController", urlPatterns = {"contactlist"}, loadOnStartup = 1)
public class ContactListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ContactListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Load contacts
		IContactRepository repository = ContactRepository.getInstance();
		Map<String,Contact> contacts = repository.getContacts();
		
		// Send contacts to index.jsp
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("/contactListView.jsp").forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
