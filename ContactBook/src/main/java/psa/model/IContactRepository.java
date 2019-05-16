package psa.model;

import java.util.Map;

public interface IContactRepository {

	Map<String, Contact> getContacts();

	void updateContact(Contact c);

	Contact getContact(String id);

	Contact addContact(String name, String telephone);

	void deleteContact(String id);

}