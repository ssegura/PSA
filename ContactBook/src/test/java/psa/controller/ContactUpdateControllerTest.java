package psa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import psa.model.Contact;
import psa.model.ContactRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)		// https://static.javadoc.io/org.mockito/mockito-core/2.6.5/org/mockito/exceptions/misusing/PotentialStubbingProblem.html
class ContactUpdateControllerTest {
	
	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;
	
	@Mock
	RequestDispatcher dispatcher;
	
	ContactRepository repository = ContactRepository.getInstance();
	
	@Before
	void setUp() {
		repository.init();
	}
	
	@Test
	@DisplayName("Redirection to update form")
	void testRedirectionToEditForm() throws ServletException, IOException {
		
		// Arrange
		ContactUpdateController servlet = new ContactUpdateController();
		when(request.getParameter("name")).thenReturn(null);
	    when(request.getParameter("phone")).thenReturn(null);
		when(request.getRequestDispatcher(any())).thenReturn(dispatcher);
		
		// Act
		servlet.doGet(request, response);
		
		// Assert
		verify(request).getRequestDispatcher("/contactEditView.jsp");
		verify(dispatcher).forward(request,response);
	}
	
	@Test
	@DisplayName("Redirection to contact list (contact updated)")
	void testUpdateContact() throws ServletException, IOException {
		
		// Arrange
		String contactId = getContactId(repository);
		String contactNewName = "Pablo López";
		String contactNewPhone = "699854555";
		
		ContactUpdateController servlet = new ContactUpdateController();
		when(request.getParameter("id")).thenReturn(contactId);
		when(request.getParameter("name")).thenReturn(contactNewName);
	    when(request.getParameter("phone")).thenReturn(contactNewPhone);
		when(request.getRequestDispatcher(any())).thenReturn(dispatcher);
		
		// Act
		servlet.doGet(request, response);
		
		// Assert
		Contact contact = repository.getContact(contactId);
		assertEquals(contactNewName, contact.getName(), "Contact's name not updated");
		assertEquals(contactNewPhone, contact.getTelephone(), "Contact's phone number not updated");
		verify(request).getRequestDispatcher("/contactlist");
		verify(dispatcher).forward(request,response);
	}
	
	// Return the id of the first contact in the repository (or null if none)
	private String getContactId(ContactRepository repository) {
		return (String) repository.getContacts().keySet().toArray()[0];
		
	}
	
}
