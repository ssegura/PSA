package psa.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import psa.model.ContactRepository;
import psa.model.IContactRepository;


@ExtendWith(MockitoExtension.class)
class ContactListControllerTest {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;
	
	@Mock
	RequestDispatcher dispatcher;
	
	@Test
	@DisplayName("Set contacts attribute")
	public void testSetContacts() throws ServletException, IOException {
		
		// Arrange
		ContactListController servlet = new ContactListController();
		when(request.getRequestDispatcher(any())).thenReturn(dispatcher);
		IContactRepository repository = ContactRepository.getInstance();
		
		// Act
		servlet.doGet(request, response);
		
		// Assert
		verify(request).setAttribute(eq("contacts"),eq(repository.getContacts()));
		// Opcional: verifyNoMoreInteractions(request);
	}
	
	@Test
	@DisplayName("Redirection to contactListView.jsp")
	public void testRedirection() throws ServletException, IOException {
		
		// Arrange
		ContactListController servlet = new ContactListController();
		when(request.getRequestDispatcher(any())).thenReturn(dispatcher);
		
		// Act
		servlet.doGet(request, response);
		
		// Assert
		verify(request).getRequestDispatcher("/contactListView.jsp");
		verify(dispatcher).forward(request,response);
		
	}
}
