package psa.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import psa.model.Contact;
import psa.model.ContactRepository;
import psa.model.IContactRepository;

@WebServlet(name = "ContactUpdateController", urlPatterns = {"contactupdate"}, loadOnStartup = 1)
public class ContactUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactUpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Request data
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		// Contact repository
		IContactRepository repository = ContactRepository.getInstance();

		// Load contact being updated
		Contact contact = repository.getContact(id);

		// Display update form with contact data on it
		if (name == null && phone == null) {

			// Forward to edit view
			RequestDispatcher rd = request.getRequestDispatcher("/contactEditView.jsp");
			request.setAttribute("contact", contact);
			rd.forward(request, response);
		}

		// Update request. Update contact and display contact list
		if (name != null && phone != null) {

			// Update contact
			contact.setName(name);
			contact.setTelephone(phone);
			repository.updateContact(contact);

			// Forward to contact list view
			request.setAttribute("message", "Contact updated successfully");
			request.getRequestDispatcher("/contactlist").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
