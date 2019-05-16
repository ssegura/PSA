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

@WebServlet(name = "ContactNewController", urlPatterns = {"contactnew"}, loadOnStartup = 1)
public class ContactNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ContactNewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Request data
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		if (name==null || phone==null) {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		// Create contact
		IContactRepository repository = ContactRepository.getInstance();
		repository.addContact(name, phone);

		// Forward to contact list view
		request.setAttribute("message", "Contact created successfully");
		request.getRequestDispatcher("/contactlist").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
